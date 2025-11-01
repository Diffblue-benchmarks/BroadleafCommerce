/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RegisterCustomerEventDiffblueTest {
  /**
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

  /**
   * Method under test:
   * {@link RegisterCustomerEvent#RegisterCustomerEvent(Object, Long)}
   */
  @Test
  public void testNewRegisterCustomerEvent() {
    // Arrange and Act
    RegisterCustomerEvent actualRegisterCustomerEvent = new RegisterCustomerEvent("Source", 1L);

    // Assert
    assertEquals("Source", actualRegisterCustomerEvent.getSource());
    assertNull(actualRegisterCustomerEvent.getCatalogId());
    assertNull(actualRegisterCustomerEvent.getProfileId());
    assertNull(actualRegisterCustomerEvent.getSiteId());
    assertNull(actualRegisterCustomerEvent.getCurrencyCode());
    assertNull(actualRegisterCustomerEvent.getLocaleCode());
    assertNull(actualRegisterCustomerEvent.getTimeZoneId());
    assertEquals(1L, actualRegisterCustomerEvent.getCustomerId().longValue());
    assertTrue(actualRegisterCustomerEvent.getContext().isEmpty());
  }
}
