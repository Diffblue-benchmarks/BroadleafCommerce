package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.controller.account.validator.UpdateAccountValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(classes = {BroadleafUpdateAccountController.class, UserDetailsService.class})
@ExtendWith(SpringExtension.class)
class BroadleafUpdateAccountControllerDiffblueTest {
  @Autowired
  private BroadleafUpdateAccountController broadleafUpdateAccountController;

  @MockBean
  private CustomerService customerService;

  @MockBean(name = "blUpdateAccountValidator")
  private UpdateAccountValidator updateAccountValidator;

  /**
   * Test
   * {@link BroadleafUpdateAccountController#viewUpdateAccount(HttpServletRequest, Model, UpdateAccountForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafUpdateAccountController#viewUpdateAccount(HttpServletRequest, Model, UpdateAccountForm)}
   */
  @Test
  @DisplayName("Test viewUpdateAccount(HttpServletRequest, Model, UpdateAccountForm)")
  @Disabled("TODO: Complete this test")
  void testViewUpdateAccount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafUpdateAccountController.class,org.springframework.security.core.userdetails.UserDetailsService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafUpdateAccountController broadleafUpdateAccountController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blUpdateAccountValidator") org.broadleafcommerce.core.web.controller.account.validator.UpdateAccountValidator updateAccountValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");

    // Act
    broadleafUpdateAccountController.viewUpdateAccount(request, model, form);
  }

  /**
   * Test
   * {@link BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testProcessUpdateAccount() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafUpdateAccountController.class,org.springframework.security.core.userdetails.UserDetailsService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafUpdateAccountController broadleafUpdateAccountController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blUpdateAccountValidator") org.broadleafcommerce.core.web.controller.account.validator.UpdateAccountValidator updateAccountValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");
    BindException result = new BindException("Target", "Object Name");

    // Act
    broadleafUpdateAccountController.processUpdateAccount(request, model, form, result,
        new RedirectAttributesModelMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafUpdateAccountController}
   *   <li>{@link BroadleafUpdateAccountController#getAccountRedirectView()}
   *   <li>{@link BroadleafUpdateAccountController#getAccountUpdatedMessage()}
   *   <li>{@link BroadleafUpdateAccountController#getUpdateAccountView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafUpdateAccountController actualBroadleafUpdateAccountController = new BroadleafUpdateAccountController();
    String actualAccountRedirectView = actualBroadleafUpdateAccountController.getAccountRedirectView();
    String actualAccountUpdatedMessage = actualBroadleafUpdateAccountController.getAccountUpdatedMessage();

    // Assert
    assertEquals("Account successfully updated", actualAccountUpdatedMessage);
    assertEquals("account/updateAccount", actualBroadleafUpdateAccountController.getUpdateAccountView());
    assertEquals("redirect:/account", actualAccountRedirectView);
  }
}
