/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class DecrementInventoryRollbackHandlerDiffblueTest {
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
