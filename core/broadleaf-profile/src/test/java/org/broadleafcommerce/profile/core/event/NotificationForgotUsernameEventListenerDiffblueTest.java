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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class NotificationForgotUsernameEventListenerDiffblueTest {
  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener = new NotificationForgotUsernameEventListener();
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotUsernameEventListener
        .createContext(new ForgotUsernameEvent("Source", "42 Main St", activeUsernames));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ForgotUsernameEvent#getActiveUsernames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext_givenArrayList_thenCallsGetActiveUsernames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener = new NotificationForgotUsernameEventListener();
    ForgotUsernameEvent event = mock(ForgotUsernameEvent.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(event.getActiveUsernames()).thenReturn(stringList);

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotUsernameEventListener.createContext(event);

    // Assert
    verify(event).getActiveUsernames();
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotUsernameEventListener()).isAsynchronous());
  }
}
