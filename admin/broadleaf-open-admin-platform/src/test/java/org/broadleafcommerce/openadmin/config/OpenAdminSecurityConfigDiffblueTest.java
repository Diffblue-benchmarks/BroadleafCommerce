package org.broadleafcommerce.openadmin.config;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OpenAdminSecurityConfig.class, PasswordEncoder.class, UserDetailsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OpenAdminSecurityConfigDiffblueTest {
  @Autowired
  private OpenAdminSecurityConfig openAdminSecurityConfig;

  /**
   * Test {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}.
   * <p>
   * Method under test:
   * {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlAdminAuthenticationProvider() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.springframework.security.core.userdetails.UserDetailsService
    //   when running class:
    //   package org.broadleafcommerce.openadmin.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.config.OpenAdminSecurityConfig.class,org.springframework.security.crypto.password.PasswordEncoder.class,org.springframework.security.core.userdetails.UserDetailsService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass48 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.config.OpenAdminSecurityConfig openAdminSecurityConfig;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    openAdminSecurityConfig.blAdminAuthenticationProvider();
  }
}
