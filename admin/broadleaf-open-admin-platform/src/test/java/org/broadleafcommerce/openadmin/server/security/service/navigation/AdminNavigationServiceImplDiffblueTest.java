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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminNavigationServiceImplDiffblueTest {
  @InjectMocks
  private AdminNavigationServiceImpl adminNavigationServiceImpl;

  @Mock
  private AdminNavigationDao adminNavigationDao;

  @Mock
  private AdminNavigationServiceExtensionManager adminNavigationServiceExtensionManager;

  /**
   * Test {@link AdminNavigationServiceImpl#save(AdminSection)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#save(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#remove(AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminModuleDTO} (default constructor).</li>
   *   <li>Then return AdminModules Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminModuleDTO} (default constructor).</li>
   *   <li>Then return AdminModules Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_givenArrayListAddAdminModuleDTO_thenReturnAdminModulesEmpty2() {
    // Arrange
    ArrayList<AdminModule> adminModuleList = new ArrayList<>();
    adminModuleList.add(new AdminModuleDTO());
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
   * <ul>
   *   <li>Then return AdminModules Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#buildMenu(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminMenu AdminNavigationServiceImpl.buildMenu(AdminUser)"})
  public void testBuildMenu_thenReturnAdminModulesEmpty() {
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
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Permissions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AdminModuleDTO} (default constructor) Sections is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AdminUserImpl} (default constructor) AllPermissions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AdminUserImpl} (default constructor) AllRoles is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
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
   * <ul>
   *   <li>When {@link AdminModuleDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewModule(AdminUser, AdminModule)"})
  public void testIsUserAuthorizedToViewModule_whenAdminModuleDTO() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, new AdminModuleDTO()));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByURI(String)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAdminSectionByURI(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionByURI(String)"})
  public void testFindAdminSectionByURI() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionByURIResult = adminNavigationServiceImpl.findAdminSectionByURI("Uri");

    // Assert
    verify(adminNavigationDao).readAdminSectionByURI(eq("Uri"));
    assertSame(adminSectionImpl, actualFindAdminSectionByURIResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)} with {@code className}, {@code sectionId}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(String, String)"})
  public void testFindAdminSectionByClassAndSectionIdWithClassNameSectionId() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByClassAndSectionId(Mockito.<Class<Object>>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionByClassAndSectionIdResult = adminNavigationServiceImpl
        .findAdminSectionByClassAndSectionId("org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator", "42");

    // Assert
    verify(adminNavigationDao).readAdminSectionByClassAndSectionId(isA(Class.class), eq("42"));
    assertSame(adminSectionImpl, actualFindAdminSectionByClassAndSectionIdResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)} with {@code className}, {@code sectionId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(String, String)"})
  public void testFindAdminSectionByClassAndSectionIdWithClassNameSectionId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminNavigationServiceImpl.findAdminSectionByClassAndSectionId("Class Name", "42"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(Class, String)} with {@code clazz}, {@code sectionId}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionByClassAndSectionId(Class, String)"})
  public void testFindAdminSectionByClassAndSectionIdWithClazzSectionId() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionByClassAndSectionId(Mockito.<Class<Object>>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    Class<Object> clazz = Object.class;

    // Act
    AdminSection actualFindAdminSectionByClassAndSectionIdResult = adminNavigationServiceImpl
        .findAdminSectionByClassAndSectionId(clazz, "42");

    // Assert
    verify(adminNavigationDao).readAdminSectionByClassAndSectionId(isA(Class.class), eq("42"));
    assertSame(adminSectionImpl, actualFindAdminSectionByClassAndSectionIdResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findAdminSectionBySectionKey(String)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAdminSectionBySectionKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findAdminSectionBySectionKey(String)"})
  public void testFindAdminSectionBySectionKey() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationDao.readAdminSectionBySectionKey(Mockito.<String>any())).thenReturn(adminSectionImpl);

    // Act
    AdminSection actualFindAdminSectionBySectionKeyResult = adminNavigationServiceImpl
        .findAdminSectionBySectionKey("Section Key");

    // Assert
    verify(adminNavigationDao).readAdminSectionBySectionKey(eq("Section Key"));
    assertSame(adminSectionImpl, actualFindAdminSectionBySectionKeyResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findBaseAdminSectionByClass(String)"})
  public void testFindBaseAdminSectionByClass() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<AdminSection> adminSectionList = new ArrayList<>();
    adminSectionList.add(adminSectionImpl);
    when(adminNavigationDao.readAdminSectionForClassName(Mockito.<String>any())).thenReturn(adminSectionList);

    // Act
    adminNavigationServiceImpl.findBaseAdminSectionByClass("Clazz");

    // Assert
    verify(adminNavigationDao).readAdminSectionForClassName(eq("Clazz"));
    verify(adminSectionImpl).getUrl();
  }

  /**
   * Test {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} {@link AdminSectionImpl#getUrl()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findBaseAdminSectionByClass(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSection AdminNavigationServiceImpl.findBaseAdminSectionByClass(String)"})
  public void testFindBaseAdminSectionByClass_givenAdminSectionImplGetUrlReturnFoo() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getUrl()).thenReturn("foo");

    ArrayList<AdminSection> adminSectionList = new ArrayList<>();
    adminSectionList.add(adminSectionImpl);
    when(adminNavigationDao.readAdminSectionForClassName(Mockito.<String>any())).thenReturn(adminSectionList);

    // Act
    adminNavigationServiceImpl.findBaseAdminSectionByClass("Clazz");

    // Assert
    verify(adminNavigationDao).readAdminSectionForClassName(eq("Clazz"));
    verify(adminSectionImpl).getUrl();
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces() {
    // Arrange, Act and Assert
    assertNull(adminNavigationServiceImpl
        .guessClassFromInterfaces("org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces2() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.openadmin.server.security.domain.AdminModule", adminNavigationServiceImpl
        .guessClassFromInterfaces("org.broadleafcommerce.openadmin.server.security.domain.AdminModuleImpl"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}.
   * <ul>
   *   <li>When {@code Clazz}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.guessClassFromInterfaces(String)"})
  public void testGuessClassFromInterfaces_whenClazz_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminNavigationServiceImpl.guessClassFromInterfaces("Clazz"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"})
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
   * <ul>
   *   <li>Then calls {@link AdminPermissionImpl#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"})
  public void testIsUserAuthorizedToViewSection_thenCallsGetName() {
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
    AdminPermissionImpl adminPermissionImpl = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl.getName()).thenReturn("Name");

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

    // Act
    boolean actualIsUserAuthorizedToViewSectionResult = adminNavigationServiceImpl
        .isUserAuthorizedToViewSection(adminUser, section);

    // Assert
    verify(adminPermissionImpl, atLeast(1)).getName();
    assertFalse(actualIsUserAuthorizedToViewSectionResult);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"})
  public void testIsUserAuthorizedToViewSection_whenAdminUserImpl() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor) AllPermissions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.isUserAuthorizedToViewSection(AdminUser, AdminSection)"})
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
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#findAllAdminSections()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.findAllAdminSections()"})
  public void testFindAllAdminSections_thenReturnEmpty() {
    // Arrange
    when(adminNavigationDao.readAllAdminSections()).thenReturn(new ArrayList<>());

    // Act
    List<AdminSection> actualFindAllAdminSectionsResult = adminNavigationServiceImpl.findAllAdminSections();

    // Assert
    verify(adminNavigationDao).readAllAdminSections();
    assertTrue(actualFindAllAdminSectionsResult.isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_given42_whenHashSetAdd42_thenReturnFalse() {
    // Arrange
    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("42");
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_givenFoo_whenHashSetAddFoo_thenReturnFalse() {
    // Arrange
    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_whenHashSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(new HashSet<>(), "Permission Name"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNavigationServiceImpl.checkPermissions(Set, String)"})
  public void testCheckPermissions_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(null, "Permission Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminNavigationServiceImpl#setAdditionalSectionAuthorizations(List)}
   *   <li>{@link AdminNavigationServiceImpl#getAdditionalSectionAuthorizations()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getAdditionalSectionAuthorizations()",
      "void AdminNavigationServiceImpl.setAdditionalSectionAuthorizations(List)"})
  public void testGettersAndSetters() {
    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();

    // Act
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);
    List<SectionAuthorization> actualAdditionalSectionAuthorizations = adminNavigationServiceImpl
        .getAdditionalSectionAuthorizations();

    // Assert
    assertTrue(actualAdditionalSectionAuthorizations.isEmpty());
    assertSame(additionalSectionAuthorizations, actualAdditionalSectionAuthorizations);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnNull() {
    // Arrange
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    AdminNavigationServiceExtensionHandler adminNavigationServiceExtensionHandler = mock(
        AdminNavigationServiceExtensionHandler.class);
    when(adminNavigationServiceExtensionHandler.overrideClassNameForSection(
        Mockito.<ExtensionResultHolder<Object>>any(), Mockito.<String>any(), Mockito.<AdminSection>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminNavigationServiceExtensionManager.getProxy()).thenReturn(adminNavigationServiceExtensionHandler);

    // Act
    String actualClassNameForSection = adminNavigationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationServiceExtensionManager).getProxy();
    verify(adminNavigationDao).readAdminSectionByURI(eq("/Section Key"));
    verify(adminNavigationServiceExtensionHandler).overrideClassNameForSection(isA(ExtensionResultHolder.class),
        eq("Section Key"), isA(AdminSection.class));
    assertNull(actualClassNameForSection);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getClassNameForSection(String)}.
   * <ul>
   *   <li>Then return {@code Section Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getClassNameForSection(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.getClassNameForSection(String)"})
  public void testGetClassNameForSection_thenReturnSectionKey() {
    // Arrange
    when(adminNavigationDao.readAdminSectionByURI(Mockito.<String>any())).thenReturn(null);
    AdminNavigationServiceExtensionHandler adminNavigationServiceExtensionHandler = mock(
        AdminNavigationServiceExtensionHandler.class);
    when(adminNavigationServiceExtensionHandler.overrideClassNameForSection(
        Mockito.<ExtensionResultHolder<Object>>any(), Mockito.<String>any(), Mockito.<AdminSection>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminNavigationServiceExtensionManager.getProxy()).thenReturn(adminNavigationServiceExtensionHandler);

    // Act
    String actualClassNameForSection = adminNavigationServiceImpl.getClassNameForSection("Section Key");

    // Assert
    verify(adminNavigationServiceExtensionManager).getProxy();
    verify(adminNavigationDao).readAdminSectionByURI(eq("/Section Key"));
    verify(adminNavigationServiceExtensionHandler).overrideClassNameForSection(isA(ExtensionResultHolder.class),
        eq("Section Key"), isNull());
    assertEquals("Section Key", actualClassNameForSection);
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenComma_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs(",").isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>When {@code --Crumb List}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenCrumbList_thenReturnSizeIsOne() {
    // Arrange and Act
    List<SectionCrumb> actualSectionCrumbs = adminNavigationServiceImpl.getSectionCrumbs("--Crumb List");

    // Assert
    assertEquals(1, actualSectionCrumbs.size());
    SectionCrumb getResult = actualSectionCrumbs.get(0);
    assertEquals("", getResult.getSectionIdentifier());
    assertEquals("Crumb List", getResult.getSectionId());
    assertNull(getResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs("").isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.getSectionCrumbs(String)"})
  public void testGetSectionCrumbs_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminNavigationServiceImpl.getSectionCrumbs(null).isEmpty());
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   * <ul>
   *   <li>When {@code _ALL__ALL_}.</li>
   *   <li>Then return {@code _ALL__ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenAllAll_thenReturnAllAll() {
    // Arrange, Act and Assert
    assertEquals("_ALL__ALL", adminNavigationServiceImpl.parseForAllPermission("_ALL__ALL_"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   * <ul>
   *   <li>When {@code __ALL_}.</li>
   *   <li>Then return {@code _ALL_ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenAll_thenReturnAllAll() {
    // Arrange, Act and Assert
    assertEquals("_ALL_ALL", adminNavigationServiceImpl.parseForAllPermission("__ALL_"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#parseForAllPermission(String)}.
   * <ul>
   *   <li>When {@code Current Permission}.</li>
   *   <li>Then return {@code Current Permission_ALL_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminNavigationServiceImpl.parseForAllPermission(String)"})
  public void testParseForAllPermission_whenCurrentPermission_thenReturnCurrentPermissionAll() {
    // Arrange, Act and Assert
    assertEquals("Current Permission_ALL_", adminNavigationServiceImpl.parseForAllPermission("Current Permission"));
  }

  /**
   * Test {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}.
   * <ul>
   *   <li>When {@link AdminModuleDTO} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminNavigationServiceImpl.buildAuthorizedSectionsList(AdminUser, AdminModule)"})
  public void testBuildAuthorizedSectionsList_whenAdminModuleDTO_thenReturnEmpty() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, new AdminModuleDTO()).isEmpty());
  }
}
