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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminForgotUsernameEventDiffblueTest {
  /**
   * Test {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminForgotUsernameEvent.<init>(Object, String, String, List)"})
  public void testNewAdminForgotUsernameEvent_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("42");
    activeUsernames.add("foo");

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", activeUsernames);

    // Assert
    assertEquals("42 Main St", actualAdminForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualAdminForgotUsernameEvent.getSource());
    assertNull(actualAdminForgotUsernameEvent.getCatalogId());
    assertNull(actualAdminForgotUsernameEvent.getProfileId());
    assertNull(actualAdminForgotUsernameEvent.getSiteId());
    assertNull(actualAdminForgotUsernameEvent.getCurrencyCode());
    assertNull(actualAdminForgotUsernameEvent.getLocaleCode());
    assertNull(actualAdminForgotUsernameEvent.getTimeZoneId());
    assertNull(actualAdminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualAdminForgotUsernameEvent.getContext().isEmpty());
    assertSame(activeUsernames, actualAdminForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return ActiveUsernames is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminForgotUsernameEvent.<init>(Object, String, String, List)"})
  public void testNewAdminForgotUsernameEvent_givenFoo_thenReturnActiveUsernamesIsArrayList() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("foo");

    // Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", activeUsernames);

    // Assert
    assertEquals("42 Main St", actualAdminForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualAdminForgotUsernameEvent.getSource());
    assertNull(actualAdminForgotUsernameEvent.getCatalogId());
    assertNull(actualAdminForgotUsernameEvent.getProfileId());
    assertNull(actualAdminForgotUsernameEvent.getSiteId());
    assertNull(actualAdminForgotUsernameEvent.getCurrencyCode());
    assertNull(actualAdminForgotUsernameEvent.getLocaleCode());
    assertNull(actualAdminForgotUsernameEvent.getTimeZoneId());
    assertNull(actualAdminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualAdminForgotUsernameEvent.getContext().isEmpty());
    assertSame(activeUsernames, actualAdminForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ActiveUsernames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminForgotUsernameEvent#AdminForgotUsernameEvent(Object, String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminForgotUsernameEvent.<init>(Object, String, String, List)"})
  public void testNewAdminForgotUsernameEvent_whenArrayList_thenReturnActiveUsernamesEmpty() {
    // Arrange and Act
    AdminForgotUsernameEvent actualAdminForgotUsernameEvent = new AdminForgotUsernameEvent("Source", "42 Main St",
        "6625550144", new ArrayList<>());

    // Assert
    assertEquals("42 Main St", actualAdminForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualAdminForgotUsernameEvent.getSource());
    assertNull(actualAdminForgotUsernameEvent.getCatalogId());
    assertNull(actualAdminForgotUsernameEvent.getProfileId());
    assertNull(actualAdminForgotUsernameEvent.getSiteId());
    assertNull(actualAdminForgotUsernameEvent.getCurrencyCode());
    assertNull(actualAdminForgotUsernameEvent.getLocaleCode());
    assertNull(actualAdminForgotUsernameEvent.getTimeZoneId());
    assertNull(actualAdminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualAdminForgotUsernameEvent.getActiveUsernames().isEmpty());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminForgotUsernameEvent.getActiveUsernames()",
      "String AdminForgotUsernameEvent.getEmailAddress()", "String AdminForgotUsernameEvent.getPhoneNumber()",
      "void AdminForgotUsernameEvent.setActiveUsernames(List)", "void AdminForgotUsernameEvent.setEmailAddress(String)",
      "void AdminForgotUsernameEvent.setPhoneNumber(String)"})
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

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", adminForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }
}
