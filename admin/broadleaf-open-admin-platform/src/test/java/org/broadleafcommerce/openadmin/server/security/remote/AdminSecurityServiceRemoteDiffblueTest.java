package org.broadleafcommerce.openadmin.server.security.remote;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
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
public class AdminSecurityServiceRemoteDiffblueTest {
  @Autowired
  private AdminSecurityServiceRemote adminSecurityServiceRemote;

  /**
   * Test {@link AdminSecurityServiceRemote#getAdminUser()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#getAdminUser()}
   */
  @Test
  public void testGetAdminUser() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminSecurityServiceRemote()).getAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#getAdminUser()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceRemote#getAdminUser()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdminUser2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.remote;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass662 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote adminSecurityServiceRemote;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceRemote()).getAdminUser();
  }

  /**
   * Test {@link AdminSecurityServiceRemote#getPersistentAdminUser()}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminSecurityServiceRemote()).getPersistentAdminUser());
  }

  /**
   * Test {@link AdminSecurityServiceRemote#getPersistentAdminUser()}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#getPersistentAdminUser()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistentAdminUser2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.remote;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass663 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote adminSecurityServiceRemote;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceRemote()).getPersistentAdminUser();
  }

  /**
   * Test
   * {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   * with {@code ceilingEntityFullyQualifiedName}, {@code operationType}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#securityCheck(String, EntityOperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSecurityCheckWithCeilingEntityFullyQualifiedNameOperationType() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.remote;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass664 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote adminSecurityServiceRemote;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceRemote()).securityCheck("Dr Jane Doe", EntityOperationType.FETCH);
  }

  /**
   * Test
   * {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   * with {@code ceilingNames}, {@code operationType}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSecurityCheckWithCeilingNamesOperationType() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.remote;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass709 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote adminSecurityServiceRemote;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminSecurityServiceRemote()).securityCheck(new String[]{"Ceiling Names"}, EntityOperationType.FETCH);
  }

  /**
   * Test
   * {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   * with {@code ceilingNames}, {@code operationType}.
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#securityCheck(String[], EntityOperationType)}
   */
  @Test
  public void testSecurityCheckWithCeilingNamesOperationType_thenThrowSecurityServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(SecurityServiceException.class,
        () -> (new AdminSecurityServiceRemote()).securityCheck((String[]) null, EntityOperationType.FETCH));
  }

  /**
   * Test
   * {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   * with {@code persistencePackage}, {@code operationType}.
   * <p>
   * Method under test:
   * {@link AdminSecurityServiceRemote#securityCheck(PersistencePackage, EntityOperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSecurityCheckWithPersistencePackageOperationType() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.remote;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass682 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote adminSecurityServiceRemote;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityServiceRemote adminSecurityServiceRemote2 = new AdminSecurityServiceRemote();

    // Act
    adminSecurityServiceRemote2.securityCheck(new PersistencePackage(), EntityOperationType.FETCH);
  }
}
