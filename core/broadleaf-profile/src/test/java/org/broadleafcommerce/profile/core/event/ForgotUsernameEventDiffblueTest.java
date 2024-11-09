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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ForgotUsernameEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotUsernameEvent#setActiveUsernames(List)}
   *   <li>{@link ForgotUsernameEvent#setEmailAddress(String)}
   *   <li>{@link ForgotUsernameEvent#setPhoneNumber(String)}
   *   <li>{@link ForgotUsernameEvent#getActiveUsernames()}
   *   <li>{@link ForgotUsernameEvent#getEmailAddress()}
   *   <li>{@link ForgotUsernameEvent#getPhoneNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ForgotUsernameEvent forgotUsernameEvent = new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    forgotUsernameEvent.setActiveUsernames(activeUsernames);
    forgotUsernameEvent.setEmailAddress("42 Main St");
    forgotUsernameEvent.setPhoneNumber("6625550144");
    List<String> actualActiveUsernames = forgotUsernameEvent.getActiveUsernames();
    String actualEmailAddress = forgotUsernameEvent.getEmailAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", forgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }
}
