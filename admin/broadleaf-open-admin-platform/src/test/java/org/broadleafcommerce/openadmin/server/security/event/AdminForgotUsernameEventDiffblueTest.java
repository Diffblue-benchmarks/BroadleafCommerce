/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;

public class AdminForgotUsernameEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminForgotUsernameEvent#setActiveUsernames(List)}
   *   <li>{@link AdminForgotUsernameEvent#setEmailAddress(String)}
   *   <li>{@link AdminForgotUsernameEvent#setPhoneNumber(String)}
   *   <li>{@link AdminForgotUsernameEvent#getActiveUsernames()}
   *   <li>{@link AdminForgotUsernameEvent#getEmailAddress()}
   *   <li>{@link AdminForgotUsernameEvent#getPhoneNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminForgotUsernameEvent adminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", new ArrayList<>());
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    adminForgotUsernameEvent.setActiveUsernames(activeUsernames);
    adminForgotUsernameEvent.setEmailAddress("42 Main St");
    adminForgotUsernameEvent.setPhoneNumber("6625550144");
    List<String> actualActiveUsernames = adminForgotUsernameEvent.getActiveUsernames();
    String actualEmailAddress = adminForgotUsernameEvent.getEmailAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", adminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }

  /**
   * Method under test:
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  public void testNewAdminForgotUsernameEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    broadleafRequestContext.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent(broadleafRequestContext,
        "42 Main St", "6625550144", activeUsernames);

    // Assert
    assertEquals("42 Main St", actualAdminForgotUsernameEvent.getEmailAddress());
    assertEquals("America/Los_Angeles", actualAdminForgotUsernameEvent.getTimeZoneId());
    Map<String, Object> context = actualAdminForgotUsernameEvent.getContext();
    assertEquals(1, context.size());
    assertEquals("America/Los_Angeles", context.get("_TIMEZONE_ID"));
    assertNull(actualAdminForgotUsernameEvent.getCatalogId());
    assertNull(actualAdminForgotUsernameEvent.getProfileId());
    assertNull(actualAdminForgotUsernameEvent.getSiteId());
    assertNull(actualAdminForgotUsernameEvent.getCurrencyCode());
    assertNull(actualAdminForgotUsernameEvent.getLocaleCode());
    assertNull(actualAdminForgotUsernameEvent.getPhoneNumber());
    List<String> activeUsernames2 = actualAdminForgotUsernameEvent.getActiveUsernames();
    assertTrue(activeUsernames2.isEmpty());
    assertSame(activeUsernames, activeUsernames2);
    assertSame(broadleafRequestContext, actualAdminForgotUsernameEvent.getSource());
  }
}
