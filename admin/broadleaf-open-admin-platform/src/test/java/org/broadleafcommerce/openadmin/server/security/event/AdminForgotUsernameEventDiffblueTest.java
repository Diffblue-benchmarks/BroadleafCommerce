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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminForgotUsernameEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminForgotUsernameEvent.getActiveUsernames()",
    "String AdminForgotUsernameEvent.getEmailAddress()",
    "String AdminForgotUsernameEvent.getPhoneNumber()",
    "void AdminForgotUsernameEvent.setActiveUsernames(List)",
    "void AdminForgotUsernameEvent.setEmailAddress(String)",
    "void AdminForgotUsernameEvent.setPhoneNumber(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminForgotUsernameEvent adminForgotUsernameEvent =
        new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", new ArrayList<>());
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    adminForgotUsernameEvent.setActiveUsernames(activeUsernames);
    adminForgotUsernameEvent.setEmailAddress("42 Main St");
    adminForgotUsernameEvent.setPhoneNumber("6625550144");
    List<String> actualActiveUsernames = adminForgotUsernameEvent.getActiveUsernames();
    String actualEmailAddress = adminForgotUsernameEvent.getEmailAddress();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", adminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }
}
