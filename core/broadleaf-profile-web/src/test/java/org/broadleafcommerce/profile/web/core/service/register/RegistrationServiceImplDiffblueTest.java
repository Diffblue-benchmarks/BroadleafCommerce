package org.broadleafcommerce.profile.web.core.service.register;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
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
class RegistrationServiceImplDiffblueTest {
  @Autowired
  private RegistrationServiceImpl registrationServiceImpl;

  /**
   * Test {@link RegistrationServiceImpl#initCustomerRegistrationForm()}.
   * <p>
   * Method under test:
   * {@link RegistrationServiceImpl#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Disabled("TODO: Complete this test")
  void testInitCustomerRegistrationForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.register;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2109 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.register.RegistrationServiceImpl registrationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RegistrationServiceImpl()).initCustomerRegistrationForm();
  }

  /**
   * Test
   * {@link RegistrationServiceImpl#addRedirectUrlToForm(RegisterCustomerForm)}.
   * <p>
   * Method under test:
   * {@link RegistrationServiceImpl#addRedirectUrlToForm(RegisterCustomerForm)}
   */
  @Test
  @DisplayName("Test addRedirectUrlToForm(RegisterCustomerForm)")
  @Disabled("TODO: Complete this test")
  void testAddRedirectUrlToForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.service.register;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1987 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.service.register.RegistrationServiceImpl registrationServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RegistrationServiceImpl registrationServiceImpl2 = new RegistrationServiceImpl();

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");

    // Act
    registrationServiceImpl2.addRedirectUrlToForm(registerCustomerForm);
  }
}
