package org.broadleafcommerce.core.workflow.state.test;

import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"/bl-applicationContext-test.xml", "/bl-applicationContext-test-security.xml",
    "/bl-applicationContext-test-module.xml"})
public class TestRollbackHandlerDiffblueTest extends AbstractTestNGSpringContextTests {
  @Autowired
  private TestRollbackHandler testRollbackHandler;

  /**
   * Test
   * {@link TestRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link TestRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test(testName = "Test rollbackState(Activity, ProcessContext, Map)")
  @Ignore("TODO: Complete this test")
  public void testRollbackState() throws RollbackFailureException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state.test;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-applicationContext-test.xml","/bl-applicationContext-test-security.xml","/bl-applicationContext-test-module.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.test.TestRollbackHandler testRollbackHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act
    testRollbackHandler.rollbackState(activity, processContext, new HashMap<>());
  }

  /**
   * Test new {@link TestRollbackHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TestRollbackHandler}
   */
  @Test(testName = "Test new TestRollbackHandler (default constructor)")
  public void testNewTestRollbackHandler() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new TestRollbackHandler();
  }
}
