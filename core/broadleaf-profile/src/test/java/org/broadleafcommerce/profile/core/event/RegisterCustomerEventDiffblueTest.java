/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegisterCustomerEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RegisterCustomerEvent#setCustomerId(Long)}
   *   <li>{@link RegisterCustomerEvent#getCustomerId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RegisterCustomerEvent registerCustomerEvent = new RegisterCustomerEvent("Source", 1L);

    // Act
    registerCustomerEvent.setCustomerId(1L);

    // Assert that nothing has changed
    assertEquals(1L, registerCustomerEvent.getCustomerId().longValue());
  }
}
