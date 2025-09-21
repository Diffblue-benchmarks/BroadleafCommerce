/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RollbackFailureExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RollbackFailureException#RollbackFailureException()}
   *   <li>{@link RollbackFailureException#setActivity(Activity)}
   *   <li>{@link RollbackFailureException#setOriginalWorkflowException(Throwable)}
   *   <li>{@link RollbackFailureException#setProcessContext(ProcessContext)}
   *   <li>{@link RollbackFailureException#setStateItems(Map)}
   *   <li>{@link RollbackFailureException#getActivity()}
   *   <li>{@link RollbackFailureException#getOriginalWorkflowException()}
   *   <li>{@link RollbackFailureException#getProcessContext()}
   *   <li>{@link RollbackFailureException#getStateItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RollbackFailureException.<init>()",
    "Activity RollbackFailureException.getActivity()",
    "Throwable RollbackFailureException.getOriginalWorkflowException()",
    "ProcessContext RollbackFailureException.getProcessContext()",
    "Map RollbackFailureException.getStateItems()",
    "void RollbackFailureException.setActivity(Activity)",
    "void RollbackFailureException.setOriginalWorkflowException(Throwable)",
    "void RollbackFailureException.setProcessContext(ProcessContext)",
    "void RollbackFailureException.setStateItems(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    actualRollbackFailureException.setActivity(activity);
    Throwable originalWorkflowException = new Throwable();
    actualRollbackFailureException.setOriginalWorkflowException(originalWorkflowException);
    DefaultProcessContextImpl<?> processContext = new DefaultProcessContextImpl<>();
    actualRollbackFailureException.setProcessContext(processContext);
    HashMap<String, Object> stateItems = new HashMap<>();
    actualRollbackFailureException.setStateItems(stateItems);
    Activity<? extends ProcessContext<?>> actualActivity =
        actualRollbackFailureException.getActivity();
    Throwable actualOriginalWorkflowException =
        actualRollbackFailureException.getOriginalWorkflowException();
    ProcessContext<?> actualProcessContext = actualRollbackFailureException.getProcessContext();
    Map<String, Object> actualStateItems = actualRollbackFailureException.getStateItems();

    // Assert
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertTrue(actualStateItems.isEmpty());
    assertSame(originalWorkflowException, actualOriginalWorkflowException);
    assertSame(stateItems, actualStateItems);
    assertSame(activity, actualActivity);
    assertSame(processContext, actualProcessContext);
  }
}
