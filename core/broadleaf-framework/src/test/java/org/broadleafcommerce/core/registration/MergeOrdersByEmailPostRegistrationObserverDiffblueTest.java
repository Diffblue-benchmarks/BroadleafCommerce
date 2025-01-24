package org.broadleafcommerce.core.registration;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MergeOrdersByEmailPostRegistrationObserverDiffblueTest {
  @Autowired
  private MergeOrdersByEmailPostRegistrationObserver mergeOrdersByEmailPostRegistrationObserver;

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#init()}.
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.registration;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5408 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.registration.MergeOrdersByEmailPostRegistrationObserver mergeOrdersByEmailPostRegistrationObserver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MergeOrdersByEmailPostRegistrationObserver()).init();
  }

  /**
   * Test
   * {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <p>
   * Method under test:
   * {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessRegistrationEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.registration;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5409 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.registration.MergeOrdersByEmailPostRegistrationObserver mergeOrdersByEmailPostRegistrationObserver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MergeOrdersByEmailPostRegistrationObserver mergeOrdersByEmailPostRegistrationObserver2 = new MergeOrdersByEmailPostRegistrationObserver();

    // Act
    mergeOrdersByEmailPostRegistrationObserver2.processRegistrationEvent(new CustomerImpl());
  }
}
