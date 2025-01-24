package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.security.util.PasswordChange;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.domain.ForgotPasswordSecurityToken;
import org.broadleafcommerce.openadmin.server.security.domain.ForgotPasswordSecurityTokenImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSecurityServiceImplDiffblueTest {
  @Autowired
  private AdminSecurityServiceImpl adminSecurityServiceImpl;

  /**
   * Test {@link AdminSecurityServiceImpl#getTokenExpiredMinutes()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#getTokenExpiredMinutes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTokenExpiredMinutes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1947 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).getTokenExpiredMinutes();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#getResetPasswordURL()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#getResetPasswordURL()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetResetPasswordURL() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1944 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).getResetPasswordURL();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#deleteAdminPermission(AdminPermission)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#deleteAdminPermission(AdminPermission)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAdminPermission() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1540 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.deleteAdminPermission(new AdminPermissionImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#deleteAdminRole(AdminRole)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#deleteAdminRole(AdminRole)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAdminRole() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1555 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.deleteAdminRole(new AdminRoleImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#deleteAdminUser(AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#deleteAdminUser(AdminUser)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteAdminUser() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1567 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.deleteAdminUser(new AdminUserImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminPermissionById(Long)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#readAdminPermissionById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAdminPermissionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2068 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAdminPermissionById(1L);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminRoleById(Long)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminRoleById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAdminRoleById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2085 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAdminRoleById(1L);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUserById(Long)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminUserById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAdminUserById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2102 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAdminUserById(1L);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#saveAdminPermission(AdminPermission)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#saveAdminPermission(AdminPermission)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveAdminPermission() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2846 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.saveAdminPermission(new AdminPermissionImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#saveAdminRole(AdminRole)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#saveAdminRole(AdminRole)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveAdminRole() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2861 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.saveAdminRole(new AdminRoleImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#saveAdminUser(AdminUser)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#saveAdminUser(AdminUser)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveAdminUser() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2873 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.saveAdminUser(new AdminUserImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#clearAdminSecurityCache()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#clearAdminSecurityCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearAdminSecurityCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1537 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).clearAdminSecurityCache();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#generateSecurePassword()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#generateSecurePassword()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateSecurePassword() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1938 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).generateSecurePassword();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(PasswordChange)} with
   * {@code passwordChange}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChangePasswordWithPasswordChange() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1375 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.changePassword(new PasswordChange("janedoe"));
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   * with {@code username}, {@code oldPassword}, {@code password},
   * {@code confirmPassword}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   * with {@code username}, {@code oldPassword}, {@code password},
   * {@code confirmPassword}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "invalidUser", "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   * with {@code username}, {@code oldPassword}, {@code password},
   * {@code confirmPassword}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou", null,
        "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   * with {@code username}, {@code oldPassword}, {@code password},
   * {@code confirmPassword}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "iloveyou", null);

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   * with {@code username}, {@code oldPassword}, {@code password},
   * {@code confirmPassword}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).changePassword("janedoe", "iloveyou", "iloveyou", "iloveyou");
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType, String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#isUserQualifiedForOperationOnCeilingEntity(AdminUser, PermissionType, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsUserQualifiedForOperationOnCeilingEntity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2021 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.isUserQualifiedForOperationOnCeilingEntity(new AdminUserImpl(), PermissionType.ALL,
        "Dr Jane Doe");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsPasswordValid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1969 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).isPasswordValid("secret", "iloveyou");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#encodePassword(String)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#encodePassword(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEncodePassword() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).encodePassword("iloveyou");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#getCache()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#getCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1941 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).getCache();
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCacheKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1253 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.buildCacheKey(new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe");
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return
   * {@code security:user:1,permType:All,ceiling:Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  public void testBuildCacheKey_givenOne_thenReturnSecurityUser1PermTypeAllCeilingDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);

    // Act
    String actualBuildCacheKeyResult = adminSecurityServiceImpl.buildCacheKey(adminUser, PermissionType.ALL,
        "Dr Jane Doe");

    // Assert
    verify(adminUser).getId();
    assertEquals("security:user:1,permType:All,ceiling:Dr Jane Doe", actualBuildCacheKeyResult);
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}.
   * <ul>
   *   <li>Then return
   * {@code security:user:null,permType:All,ceiling:Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  public void testBuildCacheKey_thenReturnSecurityUserNullPermTypeAllCeilingDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();

    // Act and Assert
    assertEquals("security:user:null,permType:All,ceiling:Dr Jane Doe",
        adminSecurityServiceImpl.buildCacheKey(new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe"));
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoesOperationExistForCeilingEntity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1586 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).doesOperationExistForCeilingEntity(PermissionType.ALL, "Dr Jane Doe");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUserByUserName(String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#readAdminUserByUserName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAdminUserByUserName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2119 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAdminUserByUserName("janedoe");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUsersByEmail(String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#readAdminUsersByEmail(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAdminUsersByEmail() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2440 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAdminUsersByEmail("jane.doe@example.org");
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminUsers()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminUsers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllAdminUsers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2768 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAllAdminUsers();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminRoles()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminRoles()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllAdminRoles() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2765 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAllAdminRoles();
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminPermissions()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminPermissions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllAdminPermissions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2762 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).readAllAdminPermissions();
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResetPasswordUsingToken() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2771 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceImpl()).resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", null, "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", null);

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidToken}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        null, "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsPasswordMismatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "invalidUser", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorCodesList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInvalidateAllTokensForAdminUser() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1950 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.invalidateAllTokensForAdminUser(new AdminUserImpl());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckUser() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1514 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminSecurityServiceImpl2.checkUser(user, new GenericResponse());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser_givenFalse_thenGenericResponseErrorCodesListFirstIsInactiveUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = mock(AdminUserImpl.class);
    when(user.getActiveStatusFlag()).thenReturn(false);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    verify(user).getActiveStatusFlag();
    verify(user).getEmail();
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser_givenTrue_thenNotGenericResponseHasErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = mock(AdminUserImpl.class);
    when(user.getActiveStatusFlag()).thenReturn(true);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    verify(user).getActiveStatusFlag();
    verify(user).getEmail();
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser_thenGenericResponseErrorCodesListFirstIsEmailNotFound() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = new AdminUserImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code invalidUser}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser_whenNull_thenGenericResponseErrorCodesListFirstIsInvalidUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(null, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckPassword() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1471 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.checkPassword("iloveyou", "iloveyou", new GenericResponse());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first
   * is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsPasswordMismatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("Password", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("passwordMismatch", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>When {@link GenericResponse} (default constructor).</li>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword_whenGenericResponse_thenNotGenericResponseHasErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckExistingPassword() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1429 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminSecurityServiceImpl2.checkExistingPassword("secret", user, new GenericResponse());
  }

  /**
   * Test
   * {@link AdminSecurityServiceImpl#isTokenExpired(ForgotPasswordSecurityToken)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceImpl#isTokenExpired(ForgotPasswordSecurityToken)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTokenExpired() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2009 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl adminSecurityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl2 = new AdminSecurityServiceImpl();

    // Act
    adminSecurityServiceImpl2.isTokenExpired(new ForgotPasswordSecurityTokenImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSecurityServiceImpl#setResetPasswordEmailInfo(EmailInfo)}
   *   <li>{@link AdminSecurityServiceImpl#setSendUsernameEmailInfo(EmailInfo)}
   *   <li>{@link AdminSecurityServiceImpl#getPASSWORD_TOKEN_LENGTH()}
   *   <li>{@link AdminSecurityServiceImpl#setPASSWORD_TOKEN_LENGTH(int)}
   *   <li>{@link AdminSecurityServiceImpl#getResetPasswordEmailInfo()}
   *   <li>{@link AdminSecurityServiceImpl#getSendUsernameEmailInfo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    EmailInfo resetPasswordEmailInfo = new EmailInfo();

    // Act
    adminSecurityServiceImpl.setResetPasswordEmailInfo(resetPasswordEmailInfo);
    EmailInfo sendUsernameEmailInfo = new EmailInfo();
    adminSecurityServiceImpl.setSendUsernameEmailInfo(sendUsernameEmailInfo);
    int actualPASSWORD_TOKEN_LENGTH = adminSecurityServiceImpl.getPASSWORD_TOKEN_LENGTH();
    adminSecurityServiceImpl.setPASSWORD_TOKEN_LENGTH(1);
    EmailInfo actualResetPasswordEmailInfo = adminSecurityServiceImpl.getResetPasswordEmailInfo();

    // Assert that nothing has changed
    assertEquals(1, actualPASSWORD_TOKEN_LENGTH);
    assertSame(resetPasswordEmailInfo, actualResetPasswordEmailInfo);
    assertSame(sendUsernameEmailInfo, adminSecurityServiceImpl.getSendUsernameEmailInfo());
  }
}
