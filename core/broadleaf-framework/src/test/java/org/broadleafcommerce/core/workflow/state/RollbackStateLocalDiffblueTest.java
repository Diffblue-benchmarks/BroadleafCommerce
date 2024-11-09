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
package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RollbackStateLocalDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RollbackStateLocal}
   *   <li>{@link RollbackStateLocal#setThreadId(String)}
   *   <li>{@link RollbackStateLocal#setWorkflowId(String)}
   *   <li>{@link RollbackStateLocal#getThreadId()}
   *   <li>{@link RollbackStateLocal#getWorkflowId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RollbackStateLocal actualRollbackStateLocal = new RollbackStateLocal();
    actualRollbackStateLocal.setThreadId("42");
    actualRollbackStateLocal.setWorkflowId("42");
    String actualThreadId = actualRollbackStateLocal.getThreadId();

    // Assert that nothing has changed
    assertEquals("42", actualThreadId);
    assertEquals("42", actualRollbackStateLocal.getWorkflowId());
  }
}
