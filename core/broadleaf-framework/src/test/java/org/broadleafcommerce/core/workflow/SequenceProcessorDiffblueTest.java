package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.util.ThirdPartyInteractionLatencySimulationActivity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext-entity.xml", "/bl-framework-applicationContext-persistence.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SequenceProcessorDiffblueTest {
  @Autowired
  private SequenceProcessor<Object, Object> sequenceProcessor;

  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   * <p>
   * Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSupports() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass680 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    sequenceProcessor.supports(new ThirdPartyInteractionLatencySimulationActivity());
  }

  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   * <ul>
   *   <li>When {@link Activity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  public void testSupports_whenActivity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.supports(mock(Activity.class)));
  }

  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   * <ul>
   *   <li>When {@link ThirdPartyInteractionLatencySimulationActivity} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  public void testSupports_whenThirdPartyInteractionLatencySimulationActivity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.supports(new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#doActivities()}.
   * <p>
   * Method under test: {@link SequenceProcessor#doActivities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoActivities() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass647 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    sequenceProcessor.doActivities();
  }

  /**
   * Test {@link SequenceProcessor#doActivities(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link SequenceProcessor#doActivities(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoActivitiesWithObject() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass648 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    sequenceProcessor.doActivities("Seed Data");
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessShouldStop() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass660 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act
    sequenceProcessor.processShouldStop(context, new ThirdPartyInteractionLatencySimulationActivity());
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_givenIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = mock(DefaultProcessContextImpl.class);
    when(context.isStopped()).thenThrow(new IllegalStateException("foo"));

    // Act
    sequenceProcessor.processShouldStop(context, new ThirdPartyInteractionLatencySimulationActivity());

    // Assert
    verify(context).isStopped();
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_givenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = mock(DefaultProcessContextImpl.class);
    when(context.isStopped()).thenReturn(true);

    // Act
    boolean actualProcessShouldStopResult = sequenceProcessor.processShouldStop(context,
        new ThirdPartyInteractionLatencySimulationActivity());

    // Assert
    verify(context).isStopped();
    assertTrue(actualProcessShouldStopResult);
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_whenDefaultProcessContextImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(sequenceProcessor.processShouldStop(context, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.processShouldStop(null, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#createContext(Object)}.
   * <p>
   * Method under test: {@link SequenceProcessor#createContext(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass635 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    sequenceProcessor.createContext("Seed Data");
  }

  /**
   * Test {@link SequenceProcessor#createContext(Object)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext_thenReturnDefaultProcessContextImpl() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProcessContextFactory<Object, Object> processContextFactory = mock(ProcessContextFactory.class);
    DefaultProcessContextImpl<Object> defaultProcessContextImpl = new DefaultProcessContextImpl<>();
    when(processContextFactory.createContext(Mockito.<Object>any())).thenReturn(defaultProcessContextImpl);

    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    sequenceProcessor.setProcessContextFactory(processContextFactory);

    // Act
    ProcessContext<Object> actualCreateContextResult = sequenceProcessor.createContext("Seed Data");

    // Assert
    verify(processContextFactory).createContext(isA(Object.class));
    assertSame(defaultProcessContextImpl, actualCreateContextResult);
  }

  /**
   * Test new {@link SequenceProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SequenceProcessor}
   */
  @Test
  public void testNewSequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SequenceProcessor<Object, Object> actualSequenceProcessor = new SequenceProcessor<>();

    // Assert
    assertEquals("Workflow Processor: null", actualSequenceProcessor.getBeanDesc());
    assertNull(actualSequenceProcessor.getBeanName());
    assertNull(actualSequenceProcessor.getDefaultErrorHandler());
    assertNull(actualSequenceProcessor.getBeanFactory());
    assertFalse(actualSequenceProcessor.isAllowEmptyActivities());
    assertTrue(actualSequenceProcessor.getActivities().isEmpty());
    assertTrue(actualSequenceProcessor.getModuleActivities().isEmpty());
    assertTrue(actualSequenceProcessor.getAutoRollbackOnError());
  }

  /**
   * Test new {@link SequenceProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SequenceProcessor}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewSequenceProcessor2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass634 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.SequenceProcessor<Ljava.lang.Object;Ljava.lang.Object;> sequenceProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new SequenceProcessor<>();
  }

  /**
   * Test
   * {@link SequenceProcessor#setProcessContextFactory(ProcessContextFactory)}.
   * <p>
   * Method under test:
   * {@link SequenceProcessor#setProcessContextFactory(ProcessContextFactory)}
   */
  @Test
  public void testSetProcessContextFactory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     SequenceProcessor.processContextFactory
    //     BaseProcessor.activities
    //     BaseProcessor.allowEmptyActivities
    //     BaseProcessor.autoRollbackOnError
    //     BaseProcessor.beanFactory
    //     BaseProcessor.beanName
    //     BaseProcessor.defaultErrorHandler
    //     BaseProcessor.moduleActivities
    //     BaseProcessor.supportLogger

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act
    sequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));
  }
}
