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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.twelvemonkeys.util.LinkedSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
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
import org.mockito.Mockito;

public class AdminNavigationServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewModule(adminUser, new AdminModuleDTO()));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewModule(AdminUser, AdminModule)}
   */
  @Test
  public void testIsUserAuthorizedToViewModule8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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

    // Act
    boolean actualIsUserAuthorizedToViewModuleResult = adminNavigationServiceImpl
        .isUserAuthorizedToViewModule(adminUser, resultModule);

    // Assert
    verify(adminPermissionImpl, atLeast(1)).getName();
    assertFalse(actualIsUserAuthorizedToViewModuleResult);
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  public void testFindAdminSectionByClassAndSectionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminNavigationServiceImpl()).findAdminSectionByClassAndSectionId("Class Name", "42"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#findAdminSectionByClassAndSectionId(String, String)}
   */
  @Test
  public void testFindAdminSectionByClassAndSectionId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    // Act and Assert
    assertNull(adminNavigationServiceImpl.findAdminSectionByClassAndSectionId("Class Name", "42"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  public void testGuessClassFromInterfaces() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminNavigationServiceImpl()).guessClassFromInterfaces("Clazz"));
    assertNull((new AdminNavigationServiceImpl())
        .guessClassFromInterfaces("org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator"));
    assertEquals("org.broadleafcommerce.openadmin.server.security.domain.AdminModule",
        (new AdminNavigationServiceImpl())
            .guessClassFromInterfaces("org.broadleafcommerce.openadmin.server.security.domain.AdminModuleImpl"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#guessClassFromInterfaces(String)}
   */
  @Test
  public void testGuessClassFromInterfaces2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    // Act and Assert
    assertNull(adminNavigationServiceImpl.guessClassFromInterfaces("Clazz"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
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
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(new HashSet<>(), "Permission Name"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdminNavigationServiceImpl()).checkPermissions(null, "Permission Name"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();

    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();

    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("42");
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertFalse(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "Permission Name"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();

    HashSet<String> authorizedPermissionNames = new HashSet<>();
    authorizedPermissionNames.add("42");
    authorizedPermissionNames.add("foo");

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames, "42"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#checkPermissions(Set, String)}
   */
  @Test
  public void testCheckPermissions6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    LinkedSet<String> authorizedPermissionNames = mock(LinkedSet.class);
    when(authorizedPermissionNames.contains(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualCheckPermissionsResult = adminNavigationServiceImpl.checkPermissions(authorizedPermissionNames,
        "Permission Name");

    // Assert
    verify(authorizedPermissionNames).contains(isA(Object.class));
    assertTrue(actualCheckPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#getSectionCrumbs(String)}
   */
  @Test
  public void testGetSectionCrumbs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdminNavigationServiceImpl()).getSectionCrumbs(null).isEmpty());
    assertTrue((new AdminNavigationServiceImpl()).getSectionCrumbs(",").isEmpty());
    assertTrue((new AdminNavigationServiceImpl()).getSectionCrumbs("").isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  public void testParseForAllPermission() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Current Permission_ALL_",
        (new AdminNavigationServiceImpl()).parseForAllPermission("Current Permission"));
    assertEquals("_ALL_ALL", (new AdminNavigationServiceImpl()).parseForAllPermission("__ALL_"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#parseForAllPermission(String)}
   */
  @Test
  public void testParseForAllPermission2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();
    additionalSectionAuthorizations.add(mock(SectionAuthorization.class));

    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);

    // Act and Assert
    assertEquals("Current Permission_ALL_", adminNavigationServiceImpl.parseForAllPermission("Current Permission"));
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}
   */
  @Test
  public void testBuildAuthorizedSectionsList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, new AdminModuleDTO()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}
   */
  @Test
  public void testBuildAuthorizedSectionsList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    AdminUser adminUser = mock(AdminUser.class);

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, new AdminModuleDTO()).isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminNavigationServiceImpl#buildAuthorizedSectionsList(AdminUser, AdminModule)}
   */
  @Test
  public void testBuildAuthorizedSectionsList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    ArrayList<AdminSection> sections = new ArrayList<>();
    sections.add(new AdminSectionImpl());

    AdminModuleDTO resultModule = new AdminModuleDTO();
    resultModule.setSections(sections);

    // Act and Assert
    assertTrue(adminNavigationServiceImpl.buildAuthorizedSectionsList(adminUser, resultModule).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AdminNavigationServiceImpl#setAdditionalSectionAuthorizations(List)}
   *   <li>{@link AdminNavigationServiceImpl#getAdditionalSectionAuthorizations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();

    // Act
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);
    List<SectionAuthorization> actualAdditionalSectionAuthorizations = adminNavigationServiceImpl
        .getAdditionalSectionAuthorizations();

    // Assert that nothing has changed
    assertTrue(actualAdditionalSectionAuthorizations.isEmpty());
    assertSame(additionalSectionAuthorizations, actualAdditionalSectionAuthorizations);
  }
}
