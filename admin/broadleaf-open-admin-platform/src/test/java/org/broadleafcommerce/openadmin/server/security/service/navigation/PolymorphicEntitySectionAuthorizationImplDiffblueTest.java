package org.broadleafcommerce.openadmin.server.security.service.navigation;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleDTO;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
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
public class PolymorphicEntitySectionAuthorizationImplDiffblueTest {
  @Autowired
  private PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl;

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsUserAuthorizedToViewSection() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service.navigation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.navigation.PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl2 = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    polymorphicEntitySectionAuthorizationImpl2.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl());
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    AdminSectionImpl section = new AdminSectionImpl();
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setPermissions(new ArrayList<>());
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setCeilingEntity("");

    // Act and Assert
    assertTrue(polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminSectionImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_whenAdminSectionImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(
        polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminUserImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_whenAdminUserImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);

    // Act and Assert
    assertTrue(
        polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#getDynamicEntityDao(String)}.
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#getDynamicEntityDao(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service.navigation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.navigation.PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PolymorphicEntitySectionAuthorizationImpl()).getDynamicEntityDao("Ceiling Entity Name");
  }
}
