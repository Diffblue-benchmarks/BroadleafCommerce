package org.broadleafcommerce.profile.web.core.service.login;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-web-applicationContext.xml",
    "/blc-config/site/bl-profile-web-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class LoginServiceImplDiffblueTest {
  @Autowired
  private LoginServiceImpl loginServiceImpl;

  /**
   * Test {@link LoginServiceImpl#loginCustomer(Customer)} with {@code customer}.
   * <p>
   * Method under test: {@link LoginServiceImpl#loginCustomer(Customer)}
   */
  @Test
  @DisplayName("Test loginCustomer(Customer) with 'customer'")
  @Disabled("TODO: Complete this test")
  void testLoginCustomerWithCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.login;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1959 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.login.LoginServiceImpl loginServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    LoginServiceImpl loginServiceImpl2 = new LoginServiceImpl();

    // Act
    loginServiceImpl2.loginCustomer(new CustomerImpl());
  }

  /**
   * Test {@link LoginServiceImpl#loginCustomer(String, String)} with
   * {@code username}, {@code clearTextPassword}.
   * <p>
   * Method under test: {@link LoginServiceImpl#loginCustomer(String, String)}
   */
  @Test
  @DisplayName("Test loginCustomer(String, String) with 'username', 'clearTextPassword'")
  @Disabled("TODO: Complete this test")
  void testLoginCustomerWithUsernameClearTextPassword() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.login;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1952 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.login.LoginServiceImpl loginServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new LoginServiceImpl()).loginCustomer("janedoe", "iloveyou");
  }

  /**
   * Test {@link LoginServiceImpl#logoutCustomer()}.
   * <p>
   * Method under test: {@link LoginServiceImpl#logoutCustomer()}
   */
  @Test
  @DisplayName("Test logoutCustomer()")
  @Disabled("TODO: Complete this test")
  void testLogoutCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.login;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1986 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.login.LoginServiceImpl loginServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new LoginServiceImpl()).logoutCustomer();
  }

  /**
   * Test {@link LoginServiceImpl#getWebRequest()}.
   * <p>
   * Method under test: {@link LoginServiceImpl#getWebRequest()}
   */
  @Test
  @DisplayName("Test getWebRequest()")
  void testGetWebRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LoginServiceImpl()).getWebRequest());
  }

  /**
   * Test {@link LoginServiceImpl#getWebRequest()}.
   * <p>
   * Method under test: {@link LoginServiceImpl#getWebRequest()}
   */
  @Test
  @DisplayName("Test getWebRequest()")
  @Disabled("TODO: Complete this test")
  void testGetWebRequest2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.login;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1951 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.login.LoginServiceImpl loginServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new LoginServiceImpl()).getWebRequest();
  }
}
