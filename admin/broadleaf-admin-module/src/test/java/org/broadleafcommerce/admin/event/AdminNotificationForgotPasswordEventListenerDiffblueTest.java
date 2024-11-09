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
import java.util.Map;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotPasswordEvent;
import org.junit.Test;

public class AdminNotificationForgotPasswordEventListenerDiffblueTest {
  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("token", 1L, "ABC123", "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then calls {@link AdminForgotPasswordEvent#getResetPasswordUrl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext_givenHttpsExampleOrgExample_thenCallsGetResetPasswordUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = mock(AdminForgotPasswordEvent.class);
    when(event.getResetPasswordUrl()).thenReturn("https://example.org/example");
    when(event.getToken()).thenReturn("ABC123");
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    verify(event).getResetPasswordUrl();
    verify(event).getToken();
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new AdminNotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
