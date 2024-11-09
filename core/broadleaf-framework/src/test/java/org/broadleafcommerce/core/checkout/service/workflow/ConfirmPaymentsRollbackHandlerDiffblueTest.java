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

import static org.junit.Assert.assertThrows;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;

public class ConfirmPaymentsRollbackHandlerDiffblueTest {
  /**
   * Test
   * {@link ConfirmPaymentsRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>Then throw {@link RollbackFailureException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfirmPaymentsRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  public void testRollbackState_thenThrowRollbackFailureException() throws RollbackFailureException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConfirmPaymentsRollbackHandler confirmPaymentsRollbackHandler = new ConfirmPaymentsRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertThrows(RollbackFailureException.class,
        () -> confirmPaymentsRollbackHandler.rollbackState(activity, processContext, new HashMap<>()));
  }
}
