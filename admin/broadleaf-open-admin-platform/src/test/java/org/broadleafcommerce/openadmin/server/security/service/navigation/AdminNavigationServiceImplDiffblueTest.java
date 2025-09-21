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
package org.broadleafcommerce.openadmin.server.security.service.navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.security.dao.AdminNavigationDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminMenu;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModule;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleDTO;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AdminNavigationServiceImplDiffblueTest {
  @Mock private AdminNavigationDao adminNavigationDao;

  @Mock private AdminNavigationServiceExtensionManager adminNavigationServiceExtensionManager;

  @InjectMocks private AdminNavigationServiceImpl adminNavigationServiceImpl;

  /**
   * Test {@link AdminNavigationServiceImpl#save(AdminSection)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#save(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.save(AdminSection)"})
  public void testSave() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.save(Mockito.<AdminSection>any())).thenReturn(adminSectionImpl);

    // Act
    AdminSection actualSaveResult = adminNavigationServiceImpl.save(new AdminSectionImpl());

    // Assert
    verify(adminNavigationDao).save(isA(AdminSection.class));
    assertSame(adminSectionImpl, actualSaveResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#remove(AdminSection)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#remove(AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminNavigationServiceImpl.remove(AdminSection)"})
  public void testRemove() {
    // Arrange
    doNothing().when(adminNavigationDao).remove(Mockito.<AdminSection>any());

    // Act
    adminNavigationServiceImpl.remove(new AdminSectionImpl());

    // Assert
    verify(adminNavigationDao).remove(isA(AdminSection.class));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminModuleDTO} (default constructor).
   *   <li>Then return AdminModules Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_givenArrayListAddAdminModuleDTO_thenReturnAdminModulesEmpty() {
    // Arrange
    ArrayList<AdminModule> adminModuleList = new ArrayList<>();
    adminModuleList.add(new AdminModuleDTO());
    when(adminNavigationDao.readAllAdminModules()).thenReturn(adminModuleList);

    // Act
    AdminMenu actualBuildMenuResult = adminNavigationServiceImpl.buildMenu(new AdminUserImpl());

    // Assert
    verify(adminNavigationDao).readAllAdminModules();
    assertTrue(actualBuildMenuResult.getAdminModules().isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminSectionImpl} (default constructor).
   *   <li>Then return AdminModules Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_givenArrayListAddAdminSectionImpl_thenReturnAdminModulesEmpty() {
    // Arrange
    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(new AdminSectionImpl());

    AdminModuleImpl adminModuleImpl = new AdminModuleImpl();
    adminModuleImpl.setDisplayOrder(1);
    adminModuleImpl.setIcon("displayOrder");
    adminModuleImpl.setId(1L);
    adminModuleImpl.setModuleKey("displayOrder");
    adminModuleImpl.setName("displayOrder");
    adminModuleImpl.setSections(sections);

    ArrayList<AdminModule> adminModuleList = new ArrayList<>();
    adminModuleList.add(adminModuleImpl);
    when(adminNavigationDao.readAllAdminModules()).thenReturn(adminModuleList);

    // Act
    AdminMenu actualBuildMenuResult = adminNavigationServiceImpl.buildMenu(new AdminUserImpl());

    // Assert
    verify(adminNavigationDao).readAllAdminModules();
    assertTrue(actualBuildMenuResult.getAdminModules().isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminUser} {@link AdminUser#getAllPermissions()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_givenNull_whenAdminUserGetAllPermissionsReturnNull() {
    // Arrange
    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(new AdminSectionImpl());

    AdminModuleImpl adminModuleImpl = new AdminModuleImpl();
    adminModuleImpl.setDisplayOrder(1);
    adminModuleImpl.setIcon("displayOrder");
    adminModuleImpl.setId(1L);
    adminModuleImpl.setModuleKey("displayOrder");
    adminModuleImpl.setName("displayOrder");
    adminModuleImpl.setSections(sections);

    ArrayList<AdminModule> adminModuleList = new ArrayList<>();
    adminModuleList.add(adminModuleImpl);
    when(adminNavigationDao.readAllAdminModules()).thenReturn(adminModuleList);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllPermissions()).thenReturn(null);
    when(adminUser.getAllRoles()).thenReturn(null);

    // Act
    AdminMenu actualBuildMenuResult = adminNavigationServiceImpl.buildMenu(adminUser);

    // Assert
    verify(adminNavigationDao).readAllAdminModules();
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    assertTrue(actualBuildMenuResult.getAdminModules().isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminUser#getAllPermissions()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_thenCallsGetAllPermissions() {
    // Arrange
    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(new AdminSectionImpl());

    AdminModuleImpl adminModuleImpl = new AdminModuleImpl();
    adminModuleImpl.setDisplayOrder(1);
    adminModuleImpl.setIcon("displayOrder");
    adminModuleImpl.setId(1L);
    adminModuleImpl.setModuleKey("displayOrder");
    adminModuleImpl.setName("displayOrder");
    adminModuleImpl.setSections(sections);

    ArrayList<AdminModule> adminModuleList = new ArrayList<>();
    adminModuleList.add(adminModuleImpl);
    when(adminNavigationDao.readAllAdminModules()).thenReturn(adminModuleList);

    LinkedHashSet<AdminPermission> adminPermissionSet = new LinkedHashSet<>();
    adminPermissionSet.add(new AdminPermissionImpl());

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllPermissions()).thenReturn(adminPermissionSet);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);

    // Act
    AdminMenu actualBuildMenuResult = adminNavigationServiceImpl.buildMenu(adminUser);

    // Assert
    verify(adminNavigationDao).readAllAdminModules();
    verify(adminUser, atLeast(1)).getAllPermissions();
    verify(adminUser, atLeast(1)).getAllRoles();
    assertTrue(actualBuildMenuResult.getAdminModules().isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}.
   *
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor).
   *   <li>Then return AdminModules Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_whenAdminUserImpl_thenReturnAdminModulesEmpty() {
    // Arrange
    when(adminNavigationDao.readAllAdminModules()).thenReturn(new ArrayList<>());

    // Act
    AdminMenu actualBuildMenuResult = adminNavigationServiceImpl.buildMenu(new AdminUserImpl());

    // Assert
    verify(adminNavigationDao).readAllAdminModules();
    assertTrue(actualBuildMenuResult.getAdminModules().isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenAdminPermissionImplNameIsEmptyString() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(permissions);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is {@code foo_bar_baz}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenAdminPermissionImplNameIsFooBarBaz() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("foo_bar_baz");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(permissions);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenAdminSectionImplPermissionsIsArrayList() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(new ArrayList<>());

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenAdminSectionImplPermissionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenHashSet() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(new HashSet<>());

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminModuleDTO} (default constructor) Sections is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenNull_whenAdminModuleDTOSectionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(null);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminUserImpl} (default constructor) AllPermissions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenNull_whenAdminUserImplAllPermissionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(null);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminUserImpl} (default constructor) AllRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_givenNull_whenAdminUserImplAllRolesIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(null);
    adminUser.setAllPermissions(allPermissions);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, resultModule));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>When {@link AdminModuleDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"
  })
  public void testIsUserAuthorizedToViewModule_whenAdminModuleDTO() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(
        adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, new AdminModuleDTO()));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByURI(String)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#findAdminSectionByURI(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionByURI(String)"})
  public void testFindAdminSectionByURI() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionByURIResult =
        adminNavigationServiceImpl.findAdminSectionByURI("Uri");

    // Assert
    verify(adminNavigationDao).readAdminSectionByURI("Uri");
    assertSame(adminSectionImpl, actualFindAdminSectionByURIResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   * with {@code className}, {@code sectionId}.
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(String, String)"
  })
  public void testFindAdminSectionByClassAndSectionIdWithClassNameSectionId() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByClassAndSectionId(
            Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionByClassAndSectionIdResult =
        adminNavigationServiceImpl.findAdminSectionByClassAndSectionId(
            "org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator", "42");

    // Assert
    verify(adminNavigationDao).readAdminSectionByClassAndSectionId(isA(Class.class), eq("42"));
    assertSame(adminSectionImpl, actualFindAdminSectionByClassAndSectionIdResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   * with {@code className}, {@code sectionId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(String, String)"
  })
  public void testFindAdminSectionByClassAndSectionIdWithClassNameSectionId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminNavigationServiceImpl.findAdminSectionByClassAndSectionId("Class Name", "42"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(Class, String)} with
   * {@code clazz}, {@code sectionId}.
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(Class, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(Class, String)"
  })
  public void testFindAdminSectionByClassAndSectionIdWithClazzSectionId() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByClassAndSectionId(
            Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    Class<Object> clazz = Object.class;

    // Act
    AdminSection actualFindAdminSectionByClassAndSectionIdResult =
        adminNavigationServiceImpl.findAdminSectionByClassAndSectionId(clazz, "42");

    // Assert
    verify(adminNavigationDao).readAdminSectionByClassAndSectionId(isA(Class.class), eq("42"));
    assertSame(adminSectionImpl, actualFindAdminSectionByClassAndSectionIdResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionBySectionKey(String)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#findAdminSectionBySectionKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSection AdminNavigationServiceImpl.findAdminSectionBySectionKey(String)"
  })
  public void testFindAdminSectionBySectionKey() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionBySectionKey(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionBySectionKeyResult =
        adminNavigationServiceImpl.findAdminSectionBySectionKey("Section Key");

    // Assert
    verify(adminNavigationDao).readAdminSectionBySectionKey("Section Key");
    assertSame(adminSectionImpl, actualFindAdminSectionBySectionKeyResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findBaseAdminSectionByClass(String)"})
  public void testFindBaseAdminSectionByClass() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenReturn("https://example.org/example");

    ArrayList<AdminSection> adminSectionList = new ArrayList<>();
    adminSectionList.add(adminSection);
    when(adminNavigationDao.readAdminSectionForClassName(Mockito.<String>any()))
        .thenReturn(adminSectionList);

    // Act
    adminNavigationServiceImpl.findBaseAdminSectionByClass("Clazz");

    // Assert
    verify(adminNavigationDao).readAdminSectionForClassName("Clazz");
    verify(adminSection).getUrl();
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminSection} {@link AdminSection#getUrl()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findBaseAdminSectionByClass(String)"})
  public void testFindBaseAdminSectionByClass_givenAdminSectionGetUrlReturnFoo() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenReturn("foo");

    ArrayList<AdminSection> adminSectionList = new ArrayList<>();
    adminSectionList.add(adminSection);
    when(adminNavigationDao.readAdminSectionForClassName(Mockito.<String>any()))
        .thenReturn(adminSectionList);

    // Act
    adminNavigationServiceImpl.findBaseAdminSectionByClass("Clazz");

    // Assert
    verify(adminNavigationDao).readAdminSectionForClassName("Clazz");
    verify(adminSection).getUrl();
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces() {
    // Arrange, Act and Assert
    assertNull(
        adminNavigationServiceImpl.guessClassFromInterfaces(
            "org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces2() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.openadmin.server.security.domain.AdminModule",
        adminNavigationServiceImpl.guessClassFromInterfaces(
            "org.broadleafcommerce.openadmin.server.security.domain.AdminModuleImpl"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   *
   * <ul>
   *   <li>When {@code Clazz}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces_whenClazz_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminNavigationServiceImpl.guessClassFromInterfaces("Clazz"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"
  })
  public void testIsUserAuthorizedToViewSection_givenAdminPermissionImplNameIsEmptyString() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl section = new AdminSectionImpl();
    section.setCeilingEntity("Ceiling Entity");
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setPermissions(permissions);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is {@code foo_bar_baz}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"
  })
  public void testIsUserAuthorizedToViewSection_givenAdminPermissionImplNameIsFooBarBaz() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("foo_bar_baz");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl section = new AdminSectionImpl();
    section.setCeilingEntity("Ceiling Entity");
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setPermissions(permissions);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"
  })
  public void testIsUserAuthorizedToViewSection_givenNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminSectionImpl section = new AdminSectionImpl();
    section.setCeilingEntity("Ceiling Entity");
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setPermissions(null);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   *
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"
  })
  public void testIsUserAuthorizedToViewSection_whenAdminUserImpl() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(
        adminNavigationServiceImpl.isUserAuthorizedToViewSection(
            adminUser, new AdminSectionImpl()));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   *
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor) AllPermissions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"
  })
  public void testIsUserAuthorizedToViewSection_whenAdminUserImplAllPermissionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(null);

    AdminSectionImpl section = new AdminSectionImpl();
    section.setCeilingEntity("Ceiling Entity");
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setPermissions(null);

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAllAdminSections()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#findAllAdminSections()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminNavigationServiceImpl.findAllAdminSections()"})
  public void testFindAllAdminSections_thenReturnEmpty() {
    // Arrange
    when(adminNavigationDao.readAllAdminSections()).thenReturn(new ArrayList<>());

    // Act
    List<AdminSection> actualFindAllAdminSectionsResult =
        adminNavigationServiceImpl.findAllAdminSections();

    // Assert
    verify(adminNavigationDao).readAllAdminSections();
    assertTrue(actualFindAllAdminSectionsResult.isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_given42_when42_thenReturnTrue() {
    // Arrange
    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("42");
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "42"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_given42_whenHashSetAdd42_thenReturnFalse() {
    // Arrange
    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("42");
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(
        adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_givenFoo_whenHashSetAddFoo_thenReturnFalse() {
    // Arrange
    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(
        adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_whenHashSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(new HashSet<>(), "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(null, "Permission Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminNavigationServiceImpl#setAdditionalSectionAuthorizations(List)}
   *   <li>{@link AdminNavigationServiceImpl#getAdditionalSectionAuthorizations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.getAdditionalSectionAuthorizations()",
    "void AdminNavigationServiceImpl.setAdditionalSectionAuthorizations(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();

    // Act
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);
    List<SectionAuthorization> actualAdditionalSectionAuthorizations =
        adminNavigationServiceImpl.getAdditionalSectionAuthorizations();

    // Assert
    assertTrue(actualAdditionalSectionAuthorizations.isEmpty());
    assertSame(additionalSectionAuthorizations, actualAdditionalSectionAuthorizations);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnNull() {
    // Arrange
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    AdminNavigationServiceExtensionHandler adminNavigationServiceExtensionHandler =
        mock(AdminNavigationServiceExtensionHandler.class);
    when(adminNavigationServiceExtensionHandler.overrideClassNameForSection(
            Mockito.<ExtensionResultHolder<Object>>any(),
            Mockito.<String>any(),
            Mockito.<AdminSection>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminNavigationServiceExtensionManager.getProxy())
        .thenReturn(adminNavigationServiceExtensionHandler);

    // Act
    String actualClassNameForSection =
        adminNavigationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationServiceExtensionManager).getProxy();
    verify(adminNavigationDao).readAdminSectionByURI("/Section Key");
    verify(adminNavigationServiceExtensionHandler)
        .overrideClassNameForSection(
            isA(ExtensionResultHolder.class), eq("Section Key"), isA(AdminSection.class));
    assertNull(actualClassNameForSection);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getClassNameForSection(String)}.
   *
   * <ul>
   *   <li>Then return {@code Section Key}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnSectionKey() {
    // Arrange
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any())).thenReturn(null);

    AdminNavigationServiceExtensionHandler adminNavigationServiceExtensionHandler =
        mock(AdminNavigationServiceExtensionHandler.class);
    when(adminNavigationServiceExtensionHandler.overrideClassNameForSection(
            Mockito.<ExtensionResultHolder<Object>>any(),
            Mockito.<String>any(),
            Mockito.<AdminSection>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminNavigationServiceExtensionManager.getProxy())
        .thenReturn(adminNavigationServiceExtensionHandler);

    // Act
    String actualClassNameForSection =
        adminNavigationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationServiceExtensionManager).getProxy();
    verify(adminNavigationDao).readAdminSectionByURI("/Section Key");
    verify(adminNavigationServiceExtensionHandler)
        .overrideClassNameForSection(isA(ExtensionResultHolder.class), eq("Section Key"), isNull());
    assertEquals("Section Key", actualClassNameForSection);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenComma_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs(",").isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>When {@code --Crumb List}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenCrumbList_thenReturnSizeIsOne() {
    // Arrange and Act
    List<SectionCrumb> actualSectionCrumbs =
        adminNavigationServiceImpl.getSectionCrumbs("--Crumb List");

    // Assert
    assertEquals(1, actualSectionCrumbs.size());
    SectionCrumb getResult = actualSectionCrumbs.get(0);
    assertEquals("", getResult.getSectionIdentifier());
    assertEquals("Crumb List", getResult.getSectionId());
    assertNull(getResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs("").isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs(null).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   *
   * <ul>
   *   <li>When {@code Current Permission}.
   *   <li>Then return {@code Current Permission_ALL_}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenCurrentPermission_thenReturnCurrentPermissionAll() {
    // Arrange, Act and Assert
    assertEquals(
        "Current Permission_ALL_",
        adminNavigationServiceImpl.parseForAllPermission("Current Permission"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   *
   * <ul>
   *   <li>When {@code _foo_bar_baz}.
   *   <li>Then return {@code _ALL_bar_baz}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenFooBarBaz_thenReturnAllBarBaz() {
    // Arrange, Act and Assert
    assertEquals("_ALL_bar_baz", adminNavigationServiceImpl.parseForAllPermission("_foo_bar_baz"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   *
   * <ul>
   *   <li>When {@code foo_bar_baz}.
   *   <li>Then return {@code foo_ALL_baz}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenFooBarBaz_thenReturnFooAllBaz() {
    // Arrange, Act and Assert
    assertEquals("foo_ALL_baz", adminNavigationServiceImpl.parseForAllPermission("foo_bar_baz"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenAdminPermissionImplNameIsEmptyString() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(permissions);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) Name is {@code foo_bar_baz}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenAdminPermissionImplNameIsFooBarBaz() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("foo_bar_baz");

    ArrayList<AdminPermission> permissions = new ArrayList<>();
    permissions.add(adminPermissionImpl);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(permissions);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenAdminSectionImplPermissionsIsArrayList() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(new ArrayList<>());

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenAdminSectionImplPermissionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    LinkedHashSet<AdminPermission> allPermissions2 = new LinkedHashSet<>();
    allPermissions2.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(allPermissions2);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenHashSet() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(new HashSet<>());

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminUserImpl} (default constructor) AllPermissions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenNull_whenAdminUserImplAllPermissionsIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setAllPermissions(null);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AdminUserImpl} (default constructor) AllRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_givenNull_whenAdminUserImplAllRolesIsNull() {
    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(null);
    adminUser.setAllPermissions(allPermissions);

    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setPermissions(null);

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(adminSectionImpl);

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setDisplayOrder(1);
    resultModule.setIcon("Icon");
    resultModule.setId(1L);
    resultModule.setModuleKey("Module Key");
    resultModule.setName("Name");
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   *
   * <ul>
   *   <li>When {@link AdminModuleDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser,
   * AdminModule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"
  })
  public void testBuildAuthorizedSectionsList_whenAdminModuleDTO() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(
        adminNavigationServiceImpl
            .buildAuthorizedSectionsList(adminUser, new AdminModuleDTO())
            .isEmpty());
  }
}
