package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertThrows;
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
public class SilentErrorHandlerDiffblueTest {
  @Autowired
  private SilentErrorHandler silentErrorHandler;

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
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
    //   public class DiffblueFakeClass691 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SilentErrorHandler silentErrorHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SilentErrorHandler silentErrorHandler2 = new SilentErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    // Act
    silentErrorHandler2.handleError(context, new Throwable());
  }

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>When {@link Throwable#Throwable()} initCause
   * {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_givenThrowable_whenThrowableInitCauseThrowable() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    Throwable th = new Throwable();
    th.initCause(new Throwable());

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(context, th));
  }

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_whenNull_thenThrowWorkflowException() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(new DefaultProcessContextImpl(), null));
  }

  /**
   * Test {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SilentErrorHandler#handleError(ProcessContext, Throwable)}
   */
  @Test
  public void testHandleError_whenThrowable_thenThrowWorkflowException() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SilentErrorHandler silentErrorHandler = new SilentErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();

    // Act and Assert
    assertThrows(WorkflowException.class, () -> silentErrorHandler.handleError(context, new Throwable()));
  }

  /**
   * Test {@link SilentErrorHandler#setBeanName(String)}.
   * <p>
   * Method under test: {@link SilentErrorHandler#setBeanName(String)}
   */
  @Test
  public void testSetBeanName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     SilentErrorHandler.name

    // Arrange and Act
    (new SilentErrorHandler()).setBeanName("Name");
  }
}
