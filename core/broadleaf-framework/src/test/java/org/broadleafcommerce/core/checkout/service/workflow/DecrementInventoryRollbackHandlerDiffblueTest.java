package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
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
public class DecrementInventoryRollbackHandlerDiffblueTest {
  @Autowired
  private DecrementInventoryRollbackHandler decrementInventoryRollbackHandler;

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollbackState() throws RollbackFailureException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1392 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.DecrementInventoryRollbackHandler decrementInventoryRollbackHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler2 = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act
    decrementInventoryRollbackHandler2.rollbackState(activity, processContext, new HashMap<>());
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, null);
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, "State Configuration");
    stateConfiguration.put(DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, null);

    // Act and Assert
    assertTrue(decrementInventoryRollbackHandler.shouldExecute(activity, processContext, stateConfiguration));
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, "State Configuration");
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, null);
    stateConfiguration.put(DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, null);

    // Act and Assert
    assertTrue(decrementInventoryRollbackHandler.shouldExecute(activity, processContext, stateConfiguration));
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(mock(CommitTaxRollbackHandler.class));
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(decrementInventoryRollbackHandler.shouldExecute(activity, processContext, new HashMap<>()));
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldExecute4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1422 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.DecrementInventoryRollbackHandler decrementInventoryRollbackHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler2 = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act
    decrementInventoryRollbackHandler2.shouldExecute(activity, processContext, new HashMap<>());
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}
   * {@link DecrementInventoryRollbackHandler#EXTENDED_ROLLBACK_STATE} is
   * {@code State Configuration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute_whenHashMapExtended_rollback_stateIsStateConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    HashMap<String, Object> stateConfiguration = new HashMap<>();
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_DECREMENTED, null);
    stateConfiguration.put(DecrementInventoryRollbackHandler.ROLLBACK_BLC_INVENTORY_INCREMENTED, null);
    stateConfiguration.put(DecrementInventoryRollbackHandler.EXTENDED_ROLLBACK_STATE, "State Configuration");

    // Act and Assert
    assertTrue(decrementInventoryRollbackHandler.shouldExecute(activity, processContext, stateConfiguration));
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute_whenHashMap_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(decrementInventoryRollbackHandler.shouldExecute(activity, processContext, new HashMap<>()));
  }

  /**
   * Test
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DecrementInventoryRollbackHandler#shouldExecute(Activity, ProcessContext, Map)}
   */
  @Test
  public void testShouldExecute_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DecrementInventoryRollbackHandler decrementInventoryRollbackHandler = new DecrementInventoryRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    // Act and Assert
    assertFalse(decrementInventoryRollbackHandler.shouldExecute(activity, new DefaultProcessContextImpl<>(), null));
  }
}
