package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.util.ThirdPartyInteractionLatencySimulationActivity;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
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
public class ActivityStateManagerImplDiffblueTest {
  @Autowired
  private ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityStateManagerImpl#getStateManager()}
   *   <li>{@link ActivityStateManagerImpl#init()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl = new ActivityStateManagerImpl<>();

    // Act
    ActivityStateManager actualStateManager = activityStateManagerImpl.getStateManager();
    activityStateManagerImpl.init();

    // Assert
    assertTrue(actualStateManager instanceof ActivityStateManagerImpl);
    assertTrue(((ActivityStateManagerImpl) actualStateManager).stateMap.isEmpty());
  }

  /**
   * Test {@link ActivityStateManagerImpl#clearAllState()}.
   * <p>
   * Method under test: {@link ActivityStateManagerImpl#clearAllState()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearAllState() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1156 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();

    // Act
    activityStateManagerImpl2.clearAllState();
  }

  /**
   * Test {@link ActivityStateManagerImpl#clearRegionState(String)}.
   * <p>
   * Method under test: {@link ActivityStateManagerImpl#clearRegionState(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearRegionState() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1157 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();

    // Act
    activityStateManagerImpl2.clearRegionState("us-east-2");
  }

  /**
   * Test
   * {@link ActivityStateManagerImpl#registerState(Activity, ProcessContext, String, RollbackHandler, Map)}
   * with {@code activity}, {@code processContext}, {@code region},
   * {@code rollbackHandler}, {@code stateItems}.
   * <p>
   * Method under test:
   * {@link ActivityStateManagerImpl#registerState(Activity, ProcessContext, String, RollbackHandler, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRegisterStateWithActivityProcessContextRegionRollbackHandlerStateItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1188 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();
    ThirdPartyInteractionLatencySimulationActivity activity = new ThirdPartyInteractionLatencySimulationActivity();
    DefaultProcessContextImpl<?> defaultProcessContextImpl = new DefaultProcessContextImpl<>();
    RollbackHandler<ProcessContext<?>> rollbackHandler = mock(RollbackHandler.class);

    // Act
    activityStateManagerImpl2.registerState(activity, defaultProcessContextImpl, "us-east-2", rollbackHandler,
        new HashMap<>());
  }

  /**
   * Test
   * {@link ActivityStateManagerImpl#registerState(Activity, ProcessContext, RollbackHandler, Map)}
   * with {@code activity}, {@code processContext}, {@code rollbackHandler},
   * {@code stateItems}.
   * <p>
   * Method under test:
   * {@link ActivityStateManagerImpl#registerState(Activity, ProcessContext, RollbackHandler, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRegisterStateWithActivityProcessContextRollbackHandlerStateItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1218 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();
    ThirdPartyInteractionLatencySimulationActivity activity = new ThirdPartyInteractionLatencySimulationActivity();
    DefaultProcessContextImpl<?> defaultProcessContextImpl = new DefaultProcessContextImpl<>();
    RollbackHandler<ProcessContext<?>> rollbackHandler = mock(RollbackHandler.class);

    // Act
    activityStateManagerImpl2.registerState(activity, defaultProcessContextImpl, rollbackHandler, new HashMap<>());
  }

  /**
   * Test {@link ActivityStateManagerImpl#registerState(RollbackHandler, Map)}
   * with {@code rollbackHandler}, {@code stateItems}.
   * <p>
   * Method under test:
   * {@link ActivityStateManagerImpl#registerState(RollbackHandler, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRegisterStateWithRollbackHandlerStateItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1245 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();
    RollbackHandler<ProcessContext<?>> rollbackHandler = mock(RollbackHandler.class);

    // Act
    activityStateManagerImpl2.registerState(rollbackHandler, new HashMap<>());
  }

  /**
   * Test {@link ActivityStateManagerImpl#rollbackAllState()}.
   * <p>
   * Method under test: {@link ActivityStateManagerImpl#rollbackAllState()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollbackAllState() throws RollbackFailureException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1253 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();

    // Act
    activityStateManagerImpl2.rollbackAllState();
  }

  /**
   * Test {@link ActivityStateManagerImpl#rollbackRegionState(String)}.
   * <p>
   * Method under test:
   * {@link ActivityStateManagerImpl#rollbackRegionState(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollbackRegionState() throws RollbackFailureException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1254 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();

    // Act
    activityStateManagerImpl2.rollbackRegionState("us-east-2");
  }

  /**
   * Test {@link ActivityStateManagerImpl#getRollbackStateLocal()}.
   * <p>
   * Method under test: {@link ActivityStateManagerImpl#getRollbackStateLocal()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRollbackStateLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.workflow.state;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1187 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.workflow.state.ActivityStateManagerImpl<Lorg.broadleafcommerce.core.workflow.ProcessContext<+Ljava.lang.Object;>;> activityStateManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ActivityStateManagerImpl<ProcessContext<?>> activityStateManagerImpl2 = new ActivityStateManagerImpl<>();

    // Act
    activityStateManagerImpl2.getRollbackStateLocal();
  }
}
