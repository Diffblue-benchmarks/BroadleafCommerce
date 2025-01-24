package org.broadleafcommerce.profile.web.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPersistedEvent;
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
class CustomerStateRefresherDiffblueTest {
  @Autowired
  private CustomerStateRefresher customerStateRefresher;

  /**
   * Test
   * {@link CustomerStateRefresher#onApplicationEvent(CustomerPersistedEvent)}
   * with {@code CustomerPersistedEvent}.
   * <p>
   * Method under test:
   * {@link CustomerStateRefresher#onApplicationEvent(CustomerPersistedEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(CustomerPersistedEvent) with 'CustomerPersistedEvent'")
  @Disabled("TODO: Complete this test")
  void testOnApplicationEventWithCustomerPersistedEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass827 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.CustomerStateRefresher customerStateRefresher;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRefresher customerStateRefresher2 = new CustomerStateRefresher();

    // Act
    customerStateRefresher2.onApplicationEvent(new CustomerPersistedEvent(new CustomerImpl()));
  }

  /**
   * Test {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}
   */
  @Test
  @DisplayName("Test resetTransientFields(Customer, Customer)")
  @Disabled("TODO: Complete this test")
  void testResetTransientFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass856 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.CustomerStateRefresher customerStateRefresher;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerStateRefresher customerStateRefresher2 = new CustomerStateRefresher();
    CustomerImpl preMergedCustomer = new CustomerImpl();

    // Act
    customerStateRefresher2.resetTransientFields(preMergedCustomer, new CustomerImpl());
  }

  /**
   * Test {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}.
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) UnencodedChallengeAnswer
   * is {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}
   */
  @Test
  @DisplayName("Test resetTransientFields(Customer, Customer); then CustomerImpl (default constructor) UnencodedChallengeAnswer is 'secret'")
  void testResetTransientFields_thenCustomerImplUnencodedChallengeAnswerIsSecret() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRefresher customerStateRefresher = new CustomerStateRefresher();
    CustomerImpl preMergedCustomer = mock(CustomerImpl.class);
    when(preMergedCustomer.isAnonymous()).thenReturn(true);
    when(preMergedCustomer.isCookied()).thenReturn(true);
    when(preMergedCustomer.isRegistered()).thenReturn(true);
    when(preMergedCustomer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(preMergedCustomer.getUnencodedPassword()).thenReturn("secret");
    when(preMergedCustomer.getTransientProperties()).thenReturn(new HashMap<>());
    CustomerImpl postMergedCustomer = new CustomerImpl();

    // Act
    customerStateRefresher.resetTransientFields(preMergedCustomer, postMergedCustomer);

    // Assert
    verify(preMergedCustomer).getTransientProperties();
    verify(preMergedCustomer).getUnencodedChallengeAnswer();
    verify(preMergedCustomer).getUnencodedPassword();
    verify(preMergedCustomer).isAnonymous();
    verify(preMergedCustomer).isCookied();
    verify(preMergedCustomer).isRegistered();
    assertEquals("secret", postMergedCustomer.getUnencodedChallengeAnswer());
    assertEquals("secret", postMergedCustomer.getUnencodedPassword());
    assertTrue(postMergedCustomer.isLoggedIn());
  }
}
