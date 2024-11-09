/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotUsernameEvent;
import org.junit.Test;

public class AdminNotificationForgotUsernameEventListenerDiffblueTest {
  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener = new AdminNotificationForgotUsernameEventListener();
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotUsernameEventListener
        .createContext(new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", activeUsernames));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult
        .get(AdminNotificationForgotUsernameEventListener.ACTIVE_USERNAMES_CONTEXT_KEY);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link AdminForgotUsernameEvent#getActiveUsernames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext_givenArrayList_thenCallsGetActiveUsernames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener = new AdminNotificationForgotUsernameEventListener();
    AdminForgotUsernameEvent event = mock(AdminForgotUsernameEvent.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(event.getActiveUsernames()).thenReturn(stringList);

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotUsernameEventListener.createContext(event);

    // Assert
    verify(event).getActiveUsernames();
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult
        .get(AdminNotificationForgotUsernameEventListener.ACTIVE_USERNAMES_CONTEXT_KEY);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new AdminNotificationForgotUsernameEventListener()).isAsynchronous());
  }
}
