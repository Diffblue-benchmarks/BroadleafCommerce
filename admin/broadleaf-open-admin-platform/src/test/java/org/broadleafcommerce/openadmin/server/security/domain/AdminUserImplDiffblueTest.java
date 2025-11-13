package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.openadmin.server.service.type.ContextType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserImplDiffblueTest {
  @Autowired private AdminUserImpl adminUserImpl;

  /**
   * Test {@link AdminUserImpl#getFlatAdditionalFields()}.
   *
   * <ul>
   *   <li>Given {@link AdminUserImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getFlatAdditionalFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdminUserImpl.getFlatAdditionalFields()"})
  public void testGetFlatAdditionalFields_givenAdminUserImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(adminUserImpl.getFlatAdditionalFields().isEmpty());
  }

  /**
   * Test {@link AdminUserImpl#getFlatAdditionalFields()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getFlatAdditionalFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdminUserImpl.getFlatAdditionalFields()"})
  public void testGetFlatAdditionalFields_thenReturnSizeIsOne() {
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
   *
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor) Value is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AdminUserImpl.getLastUsedSandBoxId()"})
  public void testGetLastUsedSandBoxId_givenAdminUserAttributeImplValueIsNull_thenReturnNull() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue(null);

    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", adminUserAttributeImpl);
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act and Assert
    assertNull(adminUserImpl.getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   *
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor) Value is space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AdminUserImpl.getLastUsedSandBoxId()"})
  public void testGetLastUsedSandBoxId_givenAdminUserAttributeImplValueIsSpace_thenReturnNull() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue(" ");

    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", adminUserAttributeImpl);
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act and Assert
    assertNull(adminUserImpl.getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   *
   * <ul>
   *   <li>Given {@link AdminUserImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AdminUserImpl.getLastUsedSandBoxId()"})
  public void testGetLastUsedSandBoxId_givenAdminUserImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminUserImpl.getLastUsedSandBoxId());
  }

  /**
   * Test {@link AdminUserImpl#getLastUsedSandBoxId()}.
   *
   * <ul>
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#getLastUsedSandBoxId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AdminUserImpl.getLastUsedSandBoxId()"})
  public void testGetLastUsedSandBoxId_thenReturnLongValueIsFortyTwo() {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", adminUserAttributeImpl);
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act and Assert
    assertEquals(42L, adminUserImpl.getLastUsedSandBoxId().longValue());
  }

  /**
   * Test {@link AdminUserImpl#setLastUsedSandBoxId(Long)}.
   *
   * <ul>
   *   <li>Then {@link AdminUserImpl} AdditionalFields is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#setLastUsedSandBoxId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserImpl.setLastUsedSandBoxId(Long)"})
  public void testSetLastUsedSandBoxId_thenAdminUserImplAdditionalFieldsIsHashMap() {
    // Arrange
    HashMap<String, AdminUserAttribute> additionalFields = new HashMap<>();
    additionalFields.put("LAST_USED_SANDBOX", new AdminUserAttributeImpl());
    adminUserImpl.setAdditionalFields(additionalFields);

    // Act
    adminUserImpl.setLastUsedSandBoxId(1L);

    // Assert that nothing has changed
    Map<String, String> flatAdditionalFields = adminUserImpl.getFlatAdditionalFields();
    assertEquals(1, flatAdditionalFields.size());
    assertTrue(flatAdditionalFields.containsKey("LAST_USED_SANDBOX"));
    assertSame(additionalFields, adminUserImpl.getAdditionalFields());
  }

  /**
   * Test {@link AdminUserImpl#setLastUsedSandBoxId(Long)}.
   *
   * <ul>
   *   <li>Then {@link AdminUserImpl} AdditionalFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserImpl#setLastUsedSandBoxId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserImpl.setLastUsedSandBoxId(Long)"})
  public void testSetLastUsedSandBoxId_thenAdminUserImplAdditionalFieldsSizeIsOne() {
    // Arrange and Act
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
   *
   * <p>Method under test: {@link AdminUserImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminUserImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(adminUserImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserImpl.<init>()",
    "Boolean AdminUserImpl.getActiveStatusFlag()",
    "Map AdminUserImpl.getAdditionalFields()",
    "Set AdminUserImpl.getAllPermissions()",
    "Set AdminUserImpl.getAllRoles()",
    "String AdminUserImpl.getContextKey()",
    "ContextType AdminUserImpl.getContextType()",
    "String AdminUserImpl.getEmail()",
    "Long AdminUserImpl.getId()",
    "String AdminUserImpl.getLogin()",
    "String AdminUserImpl.getName()",
    "SandBox AdminUserImpl.getOverrideSandBox()",
    "String AdminUserImpl.getPassword()",
    "String AdminUserImpl.getPhoneNumber()",
    "String AdminUserImpl.getUnencodedPassword()",
    "void AdminUserImpl.setActiveStatusFlag(Boolean)",
    "void AdminUserImpl.setAdditionalFields(Map)",
    "void AdminUserImpl.setAllPermissions(Set)",
    "void AdminUserImpl.setAllRoles(Set)",
    "void AdminUserImpl.setContextKey(String)",
    "void AdminUserImpl.setContextType(ContextType)",
    "void AdminUserImpl.setEmail(String)",
    "void AdminUserImpl.setId(Long)",
    "void AdminUserImpl.setLogin(String)",
    "void AdminUserImpl.setName(String)",
    "void AdminUserImpl.setOverrideSandBox(SandBox)",
    "void AdminUserImpl.setPassword(String)",
    "void AdminUserImpl.setPhoneNumber(String)",
    "void AdminUserImpl.setUnencodedPassword(String)"
  })
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
    Map<String, AdminUserAttribute> actualAdditionalFields =
        actualAdminUserImpl.getAdditionalFields();
    Set<AdminPermission> actualAllPermissions = actualAdminUserImpl.getAllPermissions();
    Set<AdminRole> actualAllRoles = actualAdminUserImpl.getAllRoles();
    String actualContextKey = actualAdminUserImpl.getContextKey();
    ContextType actualContextType = actualAdminUserImpl.getContextType();
    String actualEmail = actualAdminUserImpl.getEmail();
    Long actualId = actualAdminUserImpl.getId();
    String actualLogin = actualAdminUserImpl.getLogin();
    String actualName = actualAdminUserImpl.getName();
    SandBox actualOverrideSandBox = actualAdminUserImpl.getOverrideSandBox();
    String actualPassword = actualAdminUserImpl.getPassword();
    String actualPhoneNumber = actualAdminUserImpl.getPhoneNumber();

    // Assert
    assertEquals("6625550144", actualPhoneNumber);
    assertEquals("Login", actualLogin);
    assertEquals("Name", actualName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("secret", actualAdminUserImpl.getUnencodedPassword());
    assertNull(actualContextKey);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualAllPermissions.isEmpty());
    assertTrue(actualAllRoles.isEmpty());
    assertTrue(actualActiveStatusFlag);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(allPermissions, actualAllPermissions);
    assertSame(allRoles, actualAllRoles);
    assertSame(overrideSandBox, actualOverrideSandBox);
    assertSame(ContextType.GLOBAL, actualContextType);
  }
}
