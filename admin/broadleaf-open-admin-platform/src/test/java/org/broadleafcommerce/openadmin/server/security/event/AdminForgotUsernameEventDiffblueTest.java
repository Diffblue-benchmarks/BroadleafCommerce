/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;

public class AdminForgotUsernameEventDiffblueTest {
  /**
   * Test
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Boolean#TRUE}
   * toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  public void testNewAdminForgotUsernameEvent_givenTrueToString_whenArrayListAddTrueToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add(Boolean.TRUE.toString());
    activeUsernames.add("ThreadLocalManager.notify.orphans");

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", activeUsernames);

    // Assert
    assertEquals("Source", actualAdminForgotUsernameEvent.getSource());
    assertSame(activeUsernames, actualAdminForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Then return ActiveUsernames is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  public void testNewAdminForgotUsernameEvent_thenReturnActiveUsernamesIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("ThreadLocalManager.notify.orphans");

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", activeUsernames);

    // Assert
    assertEquals("Source", actualAdminForgotUsernameEvent.getSource());
    assertSame(activeUsernames, actualAdminForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Then return Context {@code _CURRENCY_CODE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  public void testNewAdminForgotUsernameEvent_thenReturnContextCurrencyCodeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    BroadleafCurrencyImpl broadleafCurrency = new BroadleafCurrencyImpl();
    broadleafRequestContext.setBroadleafCurrency(broadleafCurrency);

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent(broadleafRequestContext,
        "42 Main St", "6625550144", new ArrayList<>());

    // Assert
    Object source = actualAdminForgotUsernameEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualAdminForgotUsernameEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get("_CURRENCY_CODE"));
    assertSame(broadleafCurrency, ((BroadleafRequestContext) source).getBroadleafCurrency());
  }

  /**
   * Test
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Then return Source TimeZone is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  public void testNewAdminForgotUsernameEvent_thenReturnSourceTimeZoneIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent(broadleafRequestContext,
        "42 Main St", "6625550144", new ArrayList<>());

    // Assert
    Object source = actualAdminForgotUsernameEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    assertNull(((BroadleafRequestContext) source).getTimeZone());
    assertNull(((BroadleafRequestContext) source).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) source).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) source).getCurrentProfile());
    assertNull(((BroadleafRequestContext) source).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) source).getSite());
    assertTrue(actualAdminForgotUsernameEvent.getContext().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
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
}
