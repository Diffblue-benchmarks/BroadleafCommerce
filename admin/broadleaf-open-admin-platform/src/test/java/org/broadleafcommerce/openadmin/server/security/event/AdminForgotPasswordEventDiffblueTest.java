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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminForgotPasswordEventDiffblueTest {
  /**
   * Test {@link AdminForgotPasswordEvent#AdminForgotPasswordEvent(Object, Long, String, String)}.
   * <ul>
   *   <li>Then return Context {@code _SITE_ID} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminForgotPasswordEvent#AdminForgotPasswordEvent(Object, Long, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminForgotPasswordEvent.<init>(Object, Long, String, String)"})
  public void testNewAdminForgotPasswordEvent_thenReturnContextSiteIdIsNull() {
    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    SiteImpl site = new SiteImpl();
    broadleafRequestContext.setNonPersistentSite(site);

    // Act
    AdminForgotPasswordEvent actualAdminForgotPasswordEvent = new AdminForgotPasswordEvent(broadleafRequestContext, 1L,
        "ABC123", "https://example.org/example");

    // Assert
    Object source = actualAdminForgotPasswordEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualAdminForgotPasswordEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get("_SITE_ID"));
    assertSame(site, ((BroadleafRequestContext) source).getNonPersistentSite());
    assertSame(site, ((BroadleafRequestContext) source).getSite());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminForgotPasswordEvent#setAdminUserId(Long)}
   *   <li>{@link AdminForgotPasswordEvent#setResetPasswordUrl(String)}
   *   <li>{@link AdminForgotPasswordEvent#setToken(String)}
   *   <li>{@link AdminForgotPasswordEvent#getAdminUserId()}
   *   <li>{@link AdminForgotPasswordEvent#getResetPasswordUrl()}
   *   <li>{@link AdminForgotPasswordEvent#getToken()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AdminForgotPasswordEvent.getAdminUserId()",
      "String AdminForgotPasswordEvent.getResetPasswordUrl()", "String AdminForgotPasswordEvent.getToken()",
      "void AdminForgotPasswordEvent.setAdminUserId(Long)", "void AdminForgotPasswordEvent.setResetPasswordUrl(String)",
      "void AdminForgotPasswordEvent.setToken(String)"})
  public void testGettersAndSetters() {
    // Arrange
    AdminForgotPasswordEvent adminForgotPasswordEvent = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    // Act
    adminForgotPasswordEvent.setAdminUserId(1L);
    adminForgotPasswordEvent.setResetPasswordUrl("https://example.org/example");
    adminForgotPasswordEvent.setToken("ABC123");
    Long actualAdminUserId = adminForgotPasswordEvent.getAdminUserId();
    String actualResetPasswordUrl = adminForgotPasswordEvent.getResetPasswordUrl();

    // Assert
    assertEquals("ABC123", adminForgotPasswordEvent.getToken());
    assertEquals("https://example.org/example", actualResetPasswordUrl);
    assertEquals(1L, actualAdminUserId.longValue());
  }
}
