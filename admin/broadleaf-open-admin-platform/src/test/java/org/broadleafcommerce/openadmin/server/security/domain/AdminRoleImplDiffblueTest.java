package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml",
    "/applicationContext-servlet-open-admin.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminRoleImplDiffblueTest {
  @Autowired
  private AdminRoleImpl adminRoleImpl;

  /**
   * Test {@link AdminRoleImpl#checkCloneable(AdminRole)}.
   * <p>
   * Method under test: {@link AdminRoleImpl#checkCloneable(AdminRole)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable() throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl adminRoleImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminRoleImpl adminRoleImpl2 = new AdminRoleImpl();

    // Act
    adminRoleImpl2.checkCloneable(new AdminRoleImpl());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl adminRoleImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminRoleImpl()).clone();
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} {@link AdminPermissionImpl#clone()}
   * return {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>Then calls {@link AdminPermissionImpl#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminPermissionImplCloneReturnAdminPermissionImpl_thenCallsClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionImpl adminPermissionImpl = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl.clone()).thenReturn(new AdminPermissionImpl());

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(adminPermissionImpl);

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    verify(adminPermissionImpl).clone();
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1, actualCloneResult.getAllPermissions().size());
    assertEquals(1L, actualCloneResult.getId().longValue());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) AllPermissions is
   * {@code null}.</li>
   *   <li>Then return AllPermissions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminRoleImplAllPermissionsIsNull_thenReturnAllPermissionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(null);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1L, actualCloneResult.getId().longValue());
    assertTrue(actualCloneResult.getAllPermissions().isEmpty());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminRoleImpl_thenReturnIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminRole actualCloneResult = (new AdminRoleImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminRoleImpl) actualCloneResult).getMainEntityName());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add
   * {@link AdminPermissionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenLinkedHashSetAddAdminPermissionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1, actualCloneResult.getAllPermissions().size());
    assertEquals(1L, actualCloneResult.getId().longValue());
  }

  /**
   * Test {@link AdminRoleImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link AdminRoleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminRoleImpl()).getMainEntityName());
  }

  /**
   * Test {@link AdminRoleImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link AdminRoleImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl adminRoleImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminRoleImpl()).getMainEntityName();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminRoleImpl}
   *   <li>{@link AdminRoleImpl#setAllPermissions(Set)}
   *   <li>{@link AdminRoleImpl#setDescription(String)}
   *   <li>{@link AdminRoleImpl#setId(Long)}
   *   <li>{@link AdminRoleImpl#setName(String)}
   *   <li>{@link AdminRoleImpl#getAllPermissions()}
   *   <li>{@link AdminRoleImpl#getAllUsers()}
   *   <li>{@link AdminRoleImpl#getDescription()}
   *   <li>{@link AdminRoleImpl#getId()}
   *   <li>{@link AdminRoleImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminRoleImpl actualAdminRoleImpl = new AdminRoleImpl();
    HashSet<AdminPermission> allPermissions = new HashSet<>();
    actualAdminRoleImpl.setAllPermissions(allPermissions);
    actualAdminRoleImpl.setDescription("The characteristics of someone or something");
    actualAdminRoleImpl.setId(1L);
    actualAdminRoleImpl.setName("Name");
    Set<AdminPermission> actualAllPermissions = actualAdminRoleImpl.getAllPermissions();
    Set<AdminUser> actualAllUsers = actualAdminRoleImpl.getAllUsers();
    String actualDescription = actualAdminRoleImpl.getDescription();
    Long actualId = actualAdminRoleImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualAdminRoleImpl.getName());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllPermissions.isEmpty());
    assertTrue(actualAllUsers.isEmpty());
    assertSame(allPermissions, actualAllPermissions);
  }
}
