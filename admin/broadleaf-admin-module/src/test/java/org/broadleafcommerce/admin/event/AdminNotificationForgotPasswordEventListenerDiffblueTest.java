/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotPasswordEvent;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminNotificationForgotPasswordEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminNotificationForgotPasswordEventListenerDiffblueTest {
  @Autowired
  private AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener;

  @MockBean(name = "blAdminUserDao")
  private AdminUserDao adminUserDao;

  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)} with {@code AdminForgotPasswordEvent}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"})
  public void testHandleApplicationEventWithAdminForgotPasswordEvent() throws ServiceException {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    adminNotificationForgotPasswordEventListener
        .handleApplicationEvent(new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(adminUserDao).readAdminUserById(eq(1L));
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)} with {@code AdminForgotPasswordEvent}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"})
  public void testHandleApplicationEventWithAdminForgotPasswordEvent2() throws ServiceException {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    doThrow(new ServiceException("An error occurred")).when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    adminNotificationForgotPasswordEventListener
        .handleApplicationEvent(new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(adminUserDao).readAdminUserById(eq(1L));
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)} with {@code AdminForgotPasswordEvent}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"})
  public void testHandleApplicationEventWithAdminForgotPasswordEvent3() {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(null);

    // Act
    adminNotificationForgotPasswordEventListener
        .handleApplicationEvent(new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    verify(adminUserDao).readAdminUserById(eq(1L));
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminNotificationForgotPasswordEventListener.createContext(AdminForgotPasswordEvent, AdminUser)"})
  public void testCreateContext() {
    // Arrange
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("adminUser");
    assertTrue(getResult instanceof AdminUserImpl);
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminNotificationForgotPasswordEventListener.createContext(AdminForgotPasswordEvent, AdminUser)"})
  public void testCreateContext2() {
    // Arrange
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("token", 1L, "ABC123", "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("adminUser");
    assertTrue(getResult instanceof AdminUserImpl);
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test: {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminNotificationForgotPasswordEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new AdminNotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
