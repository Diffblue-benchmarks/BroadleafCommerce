package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
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
public class DefaultErrorHandlerDiffblueTest {
  @Autowired
  private DefaultErrorHandler defaultErrorHandler;

  /**
   * Test {@link DefaultErrorHandler#handleError(ProcessContext, Throwable)}.
   * <p>
   * Method under test:
   * {@link DefaultErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleError() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass600 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.DefaultErrorHandler defaultErrorHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultErrorHandler defaultErrorHandler2 = new DefaultErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    // Act
    defaultErrorHandler2.handleError(context, new Throwable());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultErrorHandler#setBeanName(String)}
   *   <li>{@link DefaultErrorHandler#setUnloggedExceptionClasses(List)}
   *   <li>{@link DefaultErrorHandler#getUnloggedExceptionClasses()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

    // Act
    defaultErrorHandler.setBeanName("Name");
    ArrayList<String> unloggedExceptionClasses = new ArrayList<>();
    defaultErrorHandler.setUnloggedExceptionClasses(unloggedExceptionClasses);
    List<String> actualUnloggedExceptionClasses = defaultErrorHandler.getUnloggedExceptionClasses();

    // Assert that nothing has changed
    assertTrue(actualUnloggedExceptionClasses.isEmpty());
    assertSame(unloggedExceptionClasses, actualUnloggedExceptionClasses);
  }
}
