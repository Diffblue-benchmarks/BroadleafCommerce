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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.openadmin.server.service.type.ContextType;
import org.junit.Test;

public class AdminUserImplDiffblueTest {
  /**
   * Test {@link AdminUserImpl#getFlatAdditionalFields()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor) OverrideSandBox is
   * {@link SandBoxImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getFlatAdditionalFields()}
   */
  @Test
  public void testGetFlatAdditionalFields_givenAdminUserImplOverrideSandBoxIsSandBoxImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setOverrideSandBox(mock(SandBoxImpl.class));

    // Act and Assert
    assertTrue(adminUserImpl.getFlatAdditionalFields().isEmpty());
  }

  /**
   * Test {@link AdminUserImpl#getFlatAdditionalFields()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getFlatAdditionalFields()}
   */
  @Test
  public void testGetFlatAdditionalFields_givenAdminUserImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdminUserImpl()).getFlatAdditionalFields().isEmpty());
  }

  /**
   * Test {@link AdminUserImpl#getFlatAdditionalFields()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getFlatAdditionalFields()}
   */
  @Test
  public void testGetFlatAdditionalFields_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("foo", new AdminUserAttributeImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act
    Map<String, String> actualFlatAdditionalFields = adminUserImpl.getFlatAdditionalFields();

    // Assert
    assertEquals(1, actualFlatAdditionalFields.size());
    assertNull(actualFlatAdditionalFields.get("foo"));
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor) OverrideSandBox is
   * {@link SandBox}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  public void testGetLastUsedSandBoxId_givenAdminUserImplOverrideSandBoxIsSandBox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", new AdminUserAttributeImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setActiveStatusFlag(true);
    adminUserImpl.setAllPermissions(new HashSet<>());
    adminUserImpl.setAllRoles(new HashSet<>());
    adminUserImpl.setEmail("jane.doe@example.org");
    adminUserImpl.setId(1L);
    adminUserImpl.setLogin("Login");
    adminUserImpl.setName("Name");
    adminUserImpl.setOverrideSandBox(mock(SandBox.class));
    adminUserImpl.setPassword("iloveyou");
    adminUserImpl.setPhoneNumber("6625550144");
    adminUserImpl.setUnencodedPassword("secret");
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act and Assert
    assertNull(adminUserImpl.getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  public void testGetLastUsedSandBoxId_givenAdminUserImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminUserImpl()).getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   * <ul>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  public void testGetLastUsedSandBoxId_thenReturnLongValueIsFortyTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = mock(AdminUserAttributeImpl.class);
    when(adminUserAttributeImpl.getValue()).thenReturn("42");

    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", adminUserAttributeImpl);

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setActiveStatusFlag(true);
    adminUserImpl.setAllPermissions(new HashSet<>());
    adminUserImpl.setAllRoles(new HashSet<>());
    adminUserImpl.setEmail("jane.doe@example.org");
    adminUserImpl.setId(1L);
    adminUserImpl.setLogin("Login");
    adminUserImpl.setName("Name");
    adminUserImpl.setOverrideSandBox(new SandBoxImpl());
    adminUserImpl.setPassword("iloveyou");
    adminUserImpl.setPhoneNumber("6625550144");
    adminUserImpl.setUnencodedPassword("secret");
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act
    Long actualLastUsedSandBoxId = adminUserImpl.getLastUsedSandBoxId();

    // Assert
    verify(adminUserAttributeImpl, atLeast(1)).getValue();
    assertEquals(42L, actualLastUsedSandBoxId.longValue());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  public void testGetLastUsedSandBoxId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", new AdminUserAttributeImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setActiveStatusFlag(true);
    adminUserImpl.setAllPermissions(new HashSet<>());
    adminUserImpl.setAllRoles(new HashSet<>());
    adminUserImpl.setEmail("jane.doe@example.org");
    adminUserImpl.setId(1L);
    adminUserImpl.setLogin("Login");
    adminUserImpl.setName("Name");
    adminUserImpl.setOverrideSandBox(new SandBoxImpl());
    adminUserImpl.setPassword("iloveyou");
    adminUserImpl.setPhoneNumber("6625550144");
    adminUserImpl.setUnencodedPassword("secret");
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act and Assert
    assertNull(adminUserImpl.getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#setLastUsedSandBoxId(Long)}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor) OverrideSandBox is
   * {@link SandBox}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#setLastUsedSandBoxId(Long)}
   */
  @Test
  public void testSetLastUsedSandBoxId_givenAdminUserImplOverrideSandBoxIsSandBox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", new AdminUserAttributeImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setActiveStatusFlag(true);
    adminUserImpl.setAllPermissions(new HashSet<>());
    adminUserImpl.setAllRoles(new HashSet<>());
    adminUserImpl.setEmail("jane.doe@example.org");
    adminUserImpl.setId(1L);
    adminUserImpl.setLogin("Login");
    adminUserImpl.setName("Name");
    adminUserImpl.setOverrideSandBox(mock(SandBox.class));
    adminUserImpl.setPassword("iloveyou");
    adminUserImpl.setPhoneNumber("6625550144");
    adminUserImpl.setUnencodedPassword("secret");
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act
    adminUserImpl.setLastUsedSandBoxId(1L);

    // Assert
    Map<String, String> flatAdditionalFields = adminUserImpl.getFlatAdditionalFields();
    assertEquals(1, flatAdditionalFields.size());
    assertTrue(flatAdditionalFields.containsKey("LAST_USED_SANDBOX"));
    assertSame(additionalFields, adminUserImpl.getAdditionalFields());
  }

  /**
   * Test {@link AdminUserImpl#setLastUsedSandBoxId(Long)}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor) OverrideSandBox is
   * {@link SandBoxImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#setLastUsedSandBoxId(Long)}
   */
  @Test
  public void testSetLastUsedSandBoxId_givenAdminUserImplOverrideSandBoxIsSandBoxImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", new AdminUserAttributeImpl());

    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setActiveStatusFlag(true);
    adminUserImpl.setAllPermissions(new HashSet<>());
    adminUserImpl.setAllRoles(new HashSet<>());
    adminUserImpl.setEmail("jane.doe@example.org");
    adminUserImpl.setId(1L);
    adminUserImpl.setLogin("Login");
    adminUserImpl.setName("Name");
    adminUserImpl.setOverrideSandBox(new SandBoxImpl());
    adminUserImpl.setPassword("iloveyou");
    adminUserImpl.setPhoneNumber("6625550144");
    adminUserImpl.setUnencodedPassword("secret");
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act
    adminUserImpl.setLastUsedSandBoxId(1L);

    // Assert
    Map<String, String> flatAdditionalFields = adminUserImpl.getFlatAdditionalFields();
    assertEquals(1, flatAdditionalFields.size());
    assertTrue(flatAdditionalFields.containsKey("LAST_USED_SANDBOX"));
    assertSame(additionalFields, adminUserImpl.getAdditionalFields());
  }

  /**
   * Test {@link AdminUserImpl#setLastUsedSandBoxId(Long)}.
   * <ul>
   *   <li>Then {@link AdminUserImpl} (default constructor) AdditionalFields size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#setLastUsedSandBoxId(Long)}
   */
  @Test
  public void testSetLastUsedSandBoxId_thenAdminUserImplAdditionalFieldsSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();

    // Act
    adminUserImpl.setLastUsedSandBoxId(1L);

    // Assert
    Map<String, AdminUserAttribute> additionalFields = adminUserImpl.getAdditionalFields();
    assertEquals(1, additionalFields.size());
    AdminUserAttribute getResult = additionalFields.get("LAST_USED_SANDBOX");
    assertTrue(getResult instanceof AdminUserAttributeImpl);
    assertEquals("LAST_USED_SANDBOX", getResult.getName());
    assertNull(getResult.getId());
    Map<String, String> flatAdditionalFields = adminUserImpl.getFlatAdditionalFields();
    assertEquals(1, flatAdditionalFields.size());
    assertTrue(flatAdditionalFields.containsKey("LAST_USED_SANDBOX"));
    assertSame(adminUserImpl, getResult.getAdminUser());
  }

  /**
   * Test {@link AdminUserImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenAdminUserImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminUserImpl()).getMainEntityName());
  }

  /**
   * Test {@link AdminUserImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link AdminUserImpl} (default constructor) OverrideSandBox is
   * {@link SandBoxImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenAdminUserImplOverrideSandBoxIsSandBoxImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    adminUserImpl.setOverrideSandBox(mock(SandBoxImpl.class));

    // Act and Assert
    assertNull(adminUserImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminUserImpl}
   *   <li>{@link AdminUserImpl#setActiveStatusFlag(Boolean)}
   *   <li>{@link AdminUserImpl#setAdditionalFields(Map)}
   *   <li>{@link AdminUserImpl#setAllPermissions(Set)}
   *   <li>{@link AdminUserImpl#setAllRoles(Set)}
   *   <li>{@link AdminUserImpl#setEmail(String)}
   *   <li>{@link AdminUserImpl#setId(Long)}
   *   <li>{@link AdminUserImpl#setLogin(String)}
   *   <li>{@link AdminUserImpl#setName(String)}
   *   <li>{@link AdminUserImpl#setOverrideSandBox(SandBox)}
   *   <li>{@link AdminUserImpl#setPassword(String)}
   *   <li>{@link AdminUserImpl#setPhoneNumber(String)}
   *   <li>{@link AdminUserImpl#setUnencodedPassword(String)}
   *   <li>{@link AdminUserImpl#setContextKey(String)}
   *   <li>{@link AdminUserImpl#setContextType(ContextType)}
   *   <li>{@link AdminUserImpl#getActiveStatusFlag()}
   *   <li>{@link AdminUserImpl#getAdditionalFields()}
   *   <li>{@link AdminUserImpl#getAllPermissions()}
   *   <li>{@link AdminUserImpl#getAllRoles()}
   *   <li>{@link AdminUserImpl#getContextKey()}
   *   <li>{@link AdminUserImpl#getContextType()}
   *   <li>{@link AdminUserImpl#getEmail()}
   *   <li>{@link AdminUserImpl#getId()}
   *   <li>{@link AdminUserImpl#getLogin()}
   *   <li>{@link AdminUserImpl#getName()}
   *   <li>{@link AdminUserImpl#getOverrideSandBox()}
   *   <li>{@link AdminUserImpl#getPassword()}
   *   <li>{@link AdminUserImpl#getPhoneNumber()}
   *   <li>{@link AdminUserImpl#getUnencodedPassword()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminUserImpl actualAdminUserImpl = new AdminUserImpl();
    actualAdminUserImpl.setActiveStatusFlag(true);
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    actualAdminUserImpl.setAdditionalFields(additionalFields);
    HashSet<AdminPermission> allPermissions = new HashSet<>();
    actualAdminUserImpl.setAllPermissions(allPermissions);
    HashSet<AdminRole> allRoles = new HashSet<>();
    actualAdminUserImpl.setAllRoles(allRoles);
    actualAdminUserImpl.setEmail("jane.doe@example.org");
    actualAdminUserImpl.setId(1L);
    actualAdminUserImpl.setLogin("Login");
    actualAdminUserImpl.setName("Name");
    SandBoxImpl overrideSandBox = new SandBoxImpl();
    actualAdminUserImpl.setOverrideSandBox(overrideSandBox);
    actualAdminUserImpl.setPassword("iloveyou");
    actualAdminUserImpl.setPhoneNumber("6625550144");
    actualAdminUserImpl.setUnencodedPassword("secret");
    actualAdminUserImpl.setContextKey("Context Key");
    actualAdminUserImpl.setContextType(ContextType.CATALOG);
    Boolean actualActiveStatusFlag = actualAdminUserImpl.getActiveStatusFlag();
    Map<String, AdminUserAttribute> actualAdditionalFields = actualAdminUserImpl.getAdditionalFields();
    Set<AdminPermission> actualAllPermissions = actualAdminUserImpl.getAllPermissions();
    Set<AdminRole> actualAllRoles = actualAdminUserImpl.getAllRoles();
    actualAdminUserImpl.getContextKey();
    ContextType actualContextType = actualAdminUserImpl.getContextType();
    String actualEmail = actualAdminUserImpl.getEmail();
    Long actualId = actualAdminUserImpl.getId();
    String actualLogin = actualAdminUserImpl.getLogin();
    String actualName = actualAdminUserImpl.getName();
    SandBox actualOverrideSandBox = actualAdminUserImpl.getOverrideSandBox();
    String actualPassword = actualAdminUserImpl.getPassword();
    String actualPhoneNumber = actualAdminUserImpl.getPhoneNumber();

    // Assert that nothing has changed
    assertEquals("6625550144", actualPhoneNumber);
    assertEquals("Login", actualLogin);
    assertEquals("Name", actualName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("secret", actualAdminUserImpl.getUnencodedPassword());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualAllPermissions.isEmpty());
    assertTrue(actualAllRoles.isEmpty());
    assertTrue(actualActiveStatusFlag);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(allPermissions, actualAllPermissions);
    assertSame(allRoles, actualAllRoles);
    assertSame(overrideSandBox, actualOverrideSandBox);
    assertSame(actualContextType.GLOBAL, actualContextType);
  }
}
